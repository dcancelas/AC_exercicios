package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Arquivos {

    public void eDirectorio(String directorio) {
        File dir = new File(directorio);
        if (dir.isDirectory()) System.out.println("É un directorio");
        else System.out.println("Non é un directorio");
    }

    public void eFicheiro(String ficheiro) {
        File file = new File(ficheiro);
        if (file.isFile()) System.out.println("É un ficheiro");
        else System.out.println("Non é un ficheiro");
    }

    public void creaDirectorio(String directorio) {
        File dir = new File(directorio);
        if (dir.exists()) System.out.println("O directorio xa existe");
        else if (dir.mkdirs()) System.out.println("O directorio creouse correctamente");
    }

    public void creaFicheiro(String dirName, String fileName) {
        File dir = new File(dirName);
        if (dir.exists()) {
            System.out.println("Existe o directorio");
            File file = new File(dirName, fileName);
            try {
                if (file.createNewFile()) System.out.println("O ficheiro creouse correctamento");
                else System.out.println("Xa existe un ficheiro co mesmo nome");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Non existe o directorio");
    }

    public void modoAcceso(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.canWrite()) System.out.println("Escritura si");
            else System.out.println("Escritura non");
            if (file.canRead()) System.out.println("Lectura si");
            else System.out.println("Lectura non");
        } else System.out.println("O ficheiro non existe");
    }

    public void calculaLonxitude(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            System.out.println("Tamaño: " + file.length() + " B");
        } else System.out.println("O ficheiro non existe");
    }

    public void mLectura(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.setReadOnly()) System.out.println("Os permisos do ficheiro cambiáronse correctamente");
            else System.out.println("Non foi posible cambiar os permisos do ficheiro");
        } else System.out.println("O ficheiro non existe");
    }

    public void mEscritura(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.setWritable(true)) System.out.println("Os permisos do ficheiro cambiáronse correctamente");
            else System.out.println("Non foi posible cambiar os permisos do ficheiro");
        } else System.out.println("O ficheiro non existe");
    }

    public void borraFicheiro(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.delete()) System.out.println("O ficheiro eliminouse correctamente");
            else System.out.println("O ficheiro non puido ser eliminado");
        } else System.out.println("O ficheiro non existe");
    }

    public void borraDirectorio(String dirName) {
        File dir = new File(dirName);
        if (dir.exists()) {
            if (dir.delete()) System.out.println("O directorio eliminouse correctamente");
            else System.out.println("O directorio non puido ser eliminado");
        } else System.out.println("O directorio non existe");
    }

    public void mContido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists()) {
            System.out.println(Arrays.toString(dir.list()));
        } else System.out.println("O directorio non existe");
    }

    public void recur(File dir) {
        if (dir.exists()) {
            String[] list = dir.list();
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
                File f1 = new File(dir, list[i]);
                if (f1.isDirectory()) mContido(f1.getAbsolutePath());
            }
        } else System.out.println("O directorio non existe");
    }
}
