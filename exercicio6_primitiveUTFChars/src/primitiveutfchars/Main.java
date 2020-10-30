package primitiveutfchars;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/primitiveUTFChars/src", "texto3.txt");
        file.delete();

        PrimitiveUTFChars primitiveUTFChars = new PrimitiveUTFChars();
        primitiveUTFChars.grabarTexto(file, "Está en casa");
    }
}
