package aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/exercicio11_aleatorio/src","produtos.txt");

        String[] codes = {"p1","p2","p3"};
        String[] descricion = {"parafusos","cravos","tachas"};
        int[] prices = {3,4,5};

        //Grabamos os datos no ficheiro
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        for (int i = 0; i < codes.length; i++) {
            raf.writeChars(String.format("%-" + 3 + "s", codes[i]));
            raf.writeChars(String.format("%-" + 10 + "s", descricion[i]));
            raf.writeInt(prices[i]);
        }

        //Lemos os datos do ficheiro
        raf.seek(0);
        for (int i = 0; i < codes.length; i++) {
            StringBuilder cod = new StringBuilder();
            StringBuilder desc = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                cod.append(raf.readChar());
            }
            for (int j = 0; j < 10; j++) {
                desc.append(raf.readChar());
            }
            int precio = raf.readInt();
            cod = new StringBuilder(cod.toString().replace(" ", ""));
            desc = new StringBuilder(desc.toString().replace(" ", ""));
            System.out.println(new Product(cod.toString(), desc.toString(), precio).toString());
        }
    }
}
