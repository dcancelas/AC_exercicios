package primitiveutfchars;

import java.io.*;

public class PrimitiveUTFChars {

    public void grabarTexto(File file, String cadea) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true));
            DataOutputStream dos = new DataOutputStream(bos);
            System.out.println("\nEscribindo no ficheiro: "+file.getName());
            dos.writeUTF(cadea);
            dos.writeChars(cadea);
            dos.writeUTF(cadea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
