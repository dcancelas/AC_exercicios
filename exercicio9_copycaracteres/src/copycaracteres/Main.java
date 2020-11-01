package copycaracteres;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file1 = new File(System.getProperty("user.dir")+"/exercicio9_copycaracteres/src", "texto10.txt");
        File file2 = new File(System.getProperty("user.dir")+"/exercicio9_copycaracteres/src", "texto11.txt");

        CopyCaracteres copyCaracteres = new CopyCaracteres();
        copyCaracteres.copiarTexto(file1, file2);
    }
}
