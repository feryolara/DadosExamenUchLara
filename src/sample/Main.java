package sample;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.concurrent.Task;
import javafx.application.Platform;



public class Main extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Examen Uch Lara");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        Button boton1 = new Button("Lanzar");
        grid.add(boton1, 1, 4);
        Button boton2 = new Button("Empezar tiempo: ");
        grid.add(boton2, 1, 2);

        //imagenes de los dados aleatoriamente

        Image dado1 = new Image ("imagenes/dado1.png");
        Image dado2 = new Image ("imagenes/dado2.png");
        Image dado3 = new Image ("imagenes/dado3.png");
        Image dado4 = new Image ("imagenes/dado4.png");
        Image dado5 = new Image ("imagenes/dado5.png");
        Image dado6 = new Image ("imagenes/dado6.png");


        //Accion del boton lanzar dado
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //genera 2 numeros aleatorios entre el 1 y 6
                int num = (int)(Math.random()*6+1);
                int num2 = (int)(Math.random()*6+1);

                //realizo una suma de los numeros generados para saber que lado del dado es
                int suma = (num+num2);

                //covierto la suma en un string para poderlo mostrar en TextField
                String sumaString = Integer.toString(suma);
                TextField lbl2 = new TextField();
                lbl2.setText(sumaString);
                grid.add(lbl2, 6, 3);

                // DIGITO y DIGITO2 se encargaran de ayudarme a saber que numero de dado se seleccionará
                ImageView DIGITO;
                DIGITO = new ImageView();
                ImageView DIGITO2;
                DIGITO2 = new ImageView();

                //Segun el numero aleatorio, será la imagen de dado que se muestra
                switch (num) {
                    case 1:
                        DIGITO.setImage(dado1);
                        grid.add(DIGITO,5,5);
                        break;
                    case 2:
                        DIGITO.setImage(dado2);
                        grid.add(DIGITO,5,5);
                        break;
                    case 3:
                        DIGITO.setImage(dado3);
                        grid.add(DIGITO,5,5);
                        break;
                    case 4:
                        DIGITO.setImage(dado4);
                        grid.add(DIGITO,5,5);
                        break;
                    case 5:
                        DIGITO.setImage(dado5);
                        grid.add(DIGITO,5,5);
                        break;
                    case 6:
                        DIGITO.setImage(dado6);
                        grid.add(DIGITO,5,5);
                        break;
                }

                switch (num2) {
                    case 1:
                        DIGITO2.setImage(dado1);
                        grid.add(DIGITO2,6,6);
                        break;

                    case 2:
                        DIGITO2.setImage(dado2);
                        grid.add(DIGITO2,6,6);
                        break;
                    case 3:
                        DIGITO2.setImage(dado3);
                        grid.add(DIGITO2,6,6);
                        break;
                    case 4:
                        DIGITO2.setImage(dado4);
                        grid.add(DIGITO2,6,6);
                        break;
                    case 5:
                        DIGITO2.setImage(dado5);
                        grid.add(DIGITO2,6,6);
                        break;
                    case 6:
                        DIGITO2.setImage(dado6);
                        grid.add(DIGITO2,6,6);
                        break;
                }
            }
        };
        boton1.setOnAction(event);

       //labels

        Label lbl1 = new Label();
        lbl1.setText("Puntos: ");
        lbl1.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        grid.add(lbl1, 1, 3);
        Label tiempo = new Label();
        tiempo.setText(" TIEMPO: ");
        tiempo.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        grid.add(tiempo, 0, 0);
        Label lbl = new Label();
        lbl.setText(" 0 ");
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        grid.add(lbl, 1, 0);

        //task donde se hace el incremento del tiempo
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {

                int numSeg = 0; //El Contador de de segundos


                while(numSeg<60) {
                    numSeg++;
                    //se usa plataform para poder modificar un elemento de la GUI
                    int finalNumSeg = numSeg;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            lbl.setText(String.valueOf(finalNumSeg));


                        }
                    });
                    try {
                        Thread.sleep(999);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   //numSeg++;
                }

                return null;
            }
        };
       //el boton 2 inicia el conteo de los 60 seg
        boton2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try{

                    Thread hilo1 = new Thread(task);
                    hilo1.start();
                    Thread.sleep(999);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }

        });

        grid.setStyle("-fx-background-color: #C86A56;");
        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);

    }
    }

