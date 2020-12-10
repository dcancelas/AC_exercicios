package exa15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class Exa15 {
    
    public static Connection conexion = null;

    public static void getConexion() throws SQLException  {
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; 
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;
        
           
        conexion = DriverManager.getConnection(ulrjdbc);
    }
     
    public static void closeConexion() throws SQLException {
        conexion.close();
    }
     
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, XMLStreamException {
        File file1 = new File(System.getProperty("user.dir")+"/src/exa15","platoss");
        File file2 = new File(System.getProperty("user.dir")+"/src/exa15","totalgraxas.xml");
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1));
        XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(file2));
        
        //Le o ficheiro platoss e almacena os datos nun ArrayList
        ArrayList<Platos> platos = new ArrayList<Platos>();
        Platos p = new Platos();
        while (p != null) {
            p = (Platos) ois.readObject();
            if (p != null) {
                platos.add(p);
            }
        }
        ois.close();
        
        //Obtén os datos restantes mediante consultas e xenera un ficheiro xml
        getConexion();
        Statement st = conexion.createStatement();
        ResultSet resultSet = null;
        
        writer.writeStartDocument("1.0");
        writer.writeStartElement("Platos");

        for (Platos plato: platos) {
            writer.writeStartElement("Plato");
            writer.writeAttribute("Codigop", plato.getCodigop());
            
            writer.writeStartElement("nomep");
            writer.writeCharacters(plato.getNomep());
            writer.writeEndElement();
            
            writer.writeStartElement("graxatotal");
            
            resultSet = st.executeQuery("select graxa from componentes where codc in (select codc from composicion where codp='"+plato.getCodigop()+"')");
            int graxaTotal = 0;
            while(resultSet.next()) {
                graxaTotal = graxaTotal + resultSet.getInt(1);
            }
            writer.writeCharacters(Integer.toString(graxaTotal));
            
            writer.writeEndElement();
           
            writer.writeEndElement();
        }

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.close();
        
        //Obtén os datos restantes mediante consultas e amosa os datos por pantalla
        for (Platos plato: platos) {
            ArrayList<String> codp = new ArrayList<String>();
            ArrayList<Integer> graxa = new ArrayList<Integer>();
            ArrayList<Integer> peso = new ArrayList<Integer>();
            int graxaTotal = 0;
            int graxaComp;
            
            resultSet = st.executeQuery("select codc,peso from composicion where codp='"+plato.getCodigop()+"'");
            while(resultSet.next()) {
                codp.add(resultSet.getString(1));
                peso.add(resultSet.getInt(2));
            }
            resultSet = st.executeQuery("select graxa from componentes where codc in (select codc from composicion where codp='"+plato.getCodigop()+"')");
            while(resultSet.next()) {
                graxa.add(resultSet.getInt(1));
            }
            
            System.out.println(
                "\nCODIGO DO PLATO: " + plato.getCodigop() +
                "\nnome do plato: " + plato.getNomep()
            );
            for (int i = 0; i < codp.size(); i++) {
                System.out.println(
                    "\ncodigo do componente: " + codp.get(i) + " -> graxa por cada 100 gr: " + graxa.get(i) +
                    "\npeso: " + peso.get(i) +
                    "\ntotal de graxa do componente: " + (graxaComp = (peso.get(i)/100)*graxa.get(i))
                );
                graxaTotal = graxaTotal + graxaComp;
            }
            System.out.println("\nTOTAL EN GRAXAS DO PLATO: " + graxaTotal + "\n");
        }
        
        closeConexion();
    }
}

   