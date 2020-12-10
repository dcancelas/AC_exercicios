package arquivos;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Arquivos arquivos = new Arquivos();
        Scanner sc = new Scanner(System.in);
        String dirName = sc.nextLine();
        String fileName = sc.nextLine();

        File dir = new File(dirName);
        arquivos.recur(dir);
    }
}
