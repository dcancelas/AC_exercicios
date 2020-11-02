package primitivewritechars;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/exercicio5_primitiveWriteChars/src", "texto3.txt");
        file.delete();

        PrimitiveWriteChars primitiveWriteUTF = new PrimitiveWriteChars();
        primitiveWriteUTF.grabarTexto(file, "o tempo está xélido");
        primitiveWriteUTF.lerTexto(file);
    }
}
