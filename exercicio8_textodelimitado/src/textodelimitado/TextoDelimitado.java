package textodelimitado;

import java.io.*;

public class TextoDelimitado {

    public static void grabarDatos(File file, String[] cod, String[] desc, Double[] prezo) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            System.out.println("Grabando datos no ficheiro: "+file.getName());
            for (int i = 0; i < cod.length; i++) {
                pw.println(cod[i]+"\t"+desc[i]+"\t"+prezo[i]);
                System.out.println("Grabado produto ("+(i+1+"/"+cod.length+")"));
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatos(File file) {
        String thisLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println("\nCargando datos do ficheiro: "+file.getName());
            while ((thisLine = br.readLine()) != null) {
                String[] datos = thisLine.split("\t");
                System.out.println(new Product(datos[0], datos[1], Double.parseDouble(datos[2])).toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
