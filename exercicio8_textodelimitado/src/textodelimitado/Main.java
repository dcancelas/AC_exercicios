package textodelimitado;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"/exercicio8_textodelimitado/src", "productos.txt");

        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos","tachas"};
        Double[] prezo ={3.0,4.0,5.0};

        TextoDelimitado.grabarDatos(file, cod, desc, prezo);
    }
}
