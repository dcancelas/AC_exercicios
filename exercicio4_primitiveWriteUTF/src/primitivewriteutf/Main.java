package primitivewriteutf;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/exercicio4_primitiveWriteUTF/src", "texto3.txt");
        file.delete();

        PrimitiveWriteUTF primitiveWriteUTF = new PrimitiveWriteUTF();
        primitiveWriteUTF.grabarTexto(file, "o tempo está xélido");
        primitiveWriteUTF.lerTexto(file);
    }
}
