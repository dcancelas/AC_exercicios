package copybytestexto;

import java.io.*;

public class Copybytexto {

    public void copiarFicheiro(File file1, File file2) {
        try {
            FileInputStream inputFile = new FileInputStream(file1);
            FileOutputStream outputFile = new FileOutputStream(file2);
            outputFile.write(inputFile.readAllBytes());
            outputFile.close();
            System.out.println("O ficheiro foi copiado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiarFicheiro(File file1, File file2, Boolean append) {
        try {
            FileInputStream inputFile = new FileInputStream(file1);
            FileOutputStream outputFile = new FileOutputStream(file2, append);
            outputFile.write(inputFile.readAllBytes());
            outputFile.close();
            System.out.println("O ficheiro foi copiado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
