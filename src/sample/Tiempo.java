package sample;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;

//Esta clase la empecé usando pero ya al final no la necesite porque use task

public class Tiempo extends Thread implements Runnable {

    public Tiempo() {// Contructor porque la clase es heredada
        super();
    }

    public void run() {
        try {
            int numSeg = 0; //El Contador de de segundos


        while(numSeg<60) {

              numSeg++; //incremento el numero de segundos


            System.out.println(":" + numSeg );//Muestro en pantalla el cronometro
            Thread.sleep(999);
        }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Imprima el error
        }


    }
}