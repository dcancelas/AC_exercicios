package copybytesimaxe;

import java.io.*;

public class Copybytesimaxe {

    public void copiarFicheiro(File file1, File file2) {
        try {
            BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(file2));
            outputFile.write(inputFile.readAllBytes());
            outputFile.close();
            System.out.println("O ficheiro foi copiado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiarFicheiro(File file1, File file2, Boolean append) {
        try {
            BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(file2, append));
            outputFile.write(inputFile.readAllBytes());
            outputFile.close();
            System.out.println("O ficheiro foi copiado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
