package serializacion1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(System.getProperty("user.dir")+"/exercicio12_serializacion1/src","serial");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Mclase mclase1 = new Mclase("ola",-7,2.7E10);
        oos.writeObject(mclase1);
        Mclase mclase2 = (Mclase) ois.readObject();
        System.out.println("mclase1: "+mclase1.toString());
        System.out.println("mclase2: "+mclase2.toString());
    }
}
