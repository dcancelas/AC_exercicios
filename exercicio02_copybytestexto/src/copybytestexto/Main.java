package copybytestexto;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File inputFile = new File(System.getProperty("user.dir")+"/exercicio02_copybytestexto/src", "texto1.txt");
        File outputFile = new File(System.getProperty("user.dir")+"/exercicio02_copybytestexto/src", "texto2.txt");

        Copybytexto copybytexto = new Copybytexto();
        //copybytexto.copiarFicheiro(inputFile, outputFile);
        copybytexto.copiarFicheiro(inputFile, outputFile, true);
    }
}
