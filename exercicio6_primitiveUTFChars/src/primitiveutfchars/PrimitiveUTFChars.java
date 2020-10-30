package primitiveutfchars;

import java.io.*;

public class PrimitiveUTFChars {

    int lonxitudeCadea;

    public void grabarTexto(File file, String cadea) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            DataOutputStream dos = new DataOutputStream(bos);
            System.out.println("\nEscribindo no ficheiro: "+file.getName());
            dos.writeUTF(cadea);
            System.out.println("writeUTF escribindo: "+cadea+"\nbytes totais escritos: "+dos.size()+" bytes");
            dos.writeChars(cadea);
            System.out.println("writeChars escribindo: "+cadea+"\nbytes totais escritos: "+dos.size()+" bytes");
            dos.writeUTF(cadea);
            lonxitudeCadea = cadea.length();
            System.out.println("writeUTF escribindo: "+cadea+"\nbytes totais escritos: "+dos.size()+" bytes");
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lerTexto(File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            DataInputStream dis = new DataInputStream(bis);
            System.out.println("\nLendo o ficheiro: "+file.getName()+"\nbytes totais por ler: "+dis.available());
            System.out.println("lemos a primeira cadea mediante readUTF(): "+dis.readUTF()+"\nnumero de bytes por ler: "+dis.available());
            StringBuilder cadea = new StringBuilder();
            for (int i = 0; i < lonxitudeCadea; i++) {
                cadea.append(dis.readChar());
            }
            System.out.println("lemos a segunda cadea mediante readChar(): "+cadea+"\nnumero de bytes por ler: "+dis.available());
            System.out.println("lemos a terceira cadea mediante readUTF(): "+dis.readUTF()+"\nnumero de bytes por ler: "+dis.available());
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
