package primitivewritechars;

import java.io.*;

public class PrimitiveWriteChars {

    int lonxitudeCadea;

    public void grabarTexto(File file, String cadea) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            DataOutputStream dos = new DataOutputStream(bos);
            System.out.println("\nEscribindo no ficheiro: "+file.getName());
            lonxitudeCadea = cadea.length();
            for (int i = 0; i < 3; i++) {
                dos.writeChars(cadea);
                System.out.println("Grabouse a cadea ("+(i+1)+"/"+3+"): "+cadea+" | Lónxitude da cadea: "+cadea.length()+" caracteres | Lévanse escritos: "+dos.size()+" B");
            }
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lerTexto(File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            DataInputStream dis = new DataInputStream(bis);
            System.out.println("\nLendo o ficheiro: "+file.getName());
            int n = 1;
            while (dis.available() != 0) {
                StringBuilder cadea = new StringBuilder();
                for (int i = 0; i < lonxitudeCadea; i++) {
                    cadea.append(dis.readChar());
                }
                System.out.println("Lemos a cadea ("+n+"/"+3+"): "+cadea+" | Restan por ler: "+dis.available()+" B");
                n++;
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
