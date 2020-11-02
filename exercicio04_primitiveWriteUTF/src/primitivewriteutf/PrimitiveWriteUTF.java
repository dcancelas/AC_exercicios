package primitivewriteutf;

import java.io.*;

public class PrimitiveWriteUTF {

    public void grabarTexto(File file, String cadea) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true));
            DataOutputStream dos = new DataOutputStream(bos);
            System.out.println("\nEscribindo no ficheiro: "+file.getName());
            for (int i = 0; i < 3; i++) {
                dos.writeUTF(cadea);
                System.out.println("Grabouse a cadea ("+(i+1)+"/"+3+"): "+cadea+" | Tamaño do ficheiro: "+dos.size()+" B");
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
                System.out.println("Lemos a cadea ("+n+"/"+3+"): "+dis.readUTF()+" | Quedan por ler: "+dis.available()+" B");
                n++;
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
