package textodelimitado;

import java.io.*;

public class TextoDelimitado {

    public static void grabarDatos(File file, String[] cod, String[] desc, Double[] prezo) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (int i = 0; i < cod.length; i++) {
                pw.println(cod[i]+"\t"+desc[i]+"\t"+prezo[i]);
                System.out.println("Grabado produto ("+(i+1+"/"+cod.length+")"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatos() {

    }
}
