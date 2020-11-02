package primitiveutfchars;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/exercicio6_primitiveUTFChars/src", "texto.txt");

        PrimitiveUTFChars primitiveUTFChars = new PrimitiveUTFChars();
        primitiveUTFChars.grabarTexto(file, "Está en mi casa");
        primitiveUTFChars.lerTexto(file);
    }
}
