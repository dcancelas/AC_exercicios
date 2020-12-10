package copybytesimaxe;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File inputFile = new File(System.getProperty("user.dir")+"/exercicio03_copybytesimaxe/src", "foto.jpg");
        File outputFile = new File(System.getProperty("user.dir")+"/exercicio03_copybytesimaxe/src", "foto2.jpg");

        Copybytesimaxe copybytesimaxe = new Copybytesimaxe();
        copybytesimaxe.copiarFicheiro(inputFile, outputFile);
        /*for (int i = 0; i < 1000; i++) {
            copybytesimaxe.copiarFicheiro(inputFile, outputFile, true);
        }*/
    }
}
