package productsstream;

import java.io.*;

public class WriteUTF {

    public static void grabarDatos(File file, Product product) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            DataOutputStream dos = new DataOutputStream(bos);
            System.out.println("Grabando datos no ficheiro: "+file.getName());
            dos.writeUTF(product.getCodigo());
            System.out.println("Datos grabados 1/3 | Tamaño do ficheiro: "+dos.size()+" bytes");
            dos.writeUTF(product.getDescricion());
            System.out.println("Datos grabados 2/3 | Tamaño do ficheiro: "+dos.size()+" bytes");
            dos.writeUTF(String.valueOf(product.getPrezo()));
            System.out.println("Datos grabados 3/3 | Tamaño do ficheiro: "+dos.size()+" bytes");
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product cargarDatos(File file) {
        Product product = new Product();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            DataInputStream dis = new DataInputStream(bis);
            System.out.println("Cargando datos do ficheiro: "+file.getName());
            product.setCodigo(dis.readUTF());
            System.out.println("Datos cargados 1/3 | Bytes por ler: "+dis.available()+" bytes");
            product.setDescricion(dis.readUTF());
            System.out.println("Datos cargados 1/3 | Bytes por ler: "+dis.available()+" bytes");
            product.setPrezo(Double.valueOf(dis.readUTF()));
            System.out.println("Datos cargados 1/3 | Bytes por ler: "+dis.available()+" bytes");
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  product;
    }
}
