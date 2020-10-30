package productsstream;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/exercicio7_productsStream/src", "productos.txt");

        Product product1 = new Product("cod1", "parafusos", 3.0);
        WriteUTF.grabarDatos(file, product1);
        Product product2 = WriteUTF.cargarDatos(file);
        System.out.println(product1.toString());
        System.out.println(product2.toString());
    }
}
