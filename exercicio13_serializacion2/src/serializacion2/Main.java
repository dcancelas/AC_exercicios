package serializacion2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(System.getProperty("user.dir")+"/exercicio13_serializacion2/src","serial");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos ","tachas"};
        Double[] prezo ={3.0,4.0,5.0};
        for (int i = 0; i < cod.length; i++) {
            oos.writeObject(new Product(cod[i],desc[i],prezo[i]));
        }

        for (int i = 0; i < cod.length; i++) {
            Product product = (Product) ois.readObject();
            System.out.println(product.toString());
        }
    }
}
