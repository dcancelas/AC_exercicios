package copycaracteres;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCaracteres {

    public void copiarTexto(File file1, File file2) {
        try {
            FileReader fr = new FileReader(file1);
            FileWriter fw = new FileWriter(file2);
            int caracter;
            while ((caracter = fr.read()) != -1) {
                fw.write(caracter);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
