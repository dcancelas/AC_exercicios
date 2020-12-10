package exa15v2;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.xml.stream.*;

public class Exa15v2 {
    
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

    public static void main(String[] args) throws XMLStreamException, IOException, SQLException, ClassNotFoundException {
        File platosf = new File(System.getProperty("user.dir")+"/src/exa15v2","platos.xml");
        File compf = new File(System.getProperty("user.dir")+"/src/exa15v2","composicion.txt");
        File tgraxasf = new File(System.getProperty("user.dir")+"/src/exa15v2","totalgraxas");
                
        getConexion();
        Statement st = conexion.createStatement();
        ResultSet resultSet = null;
        
        ArrayList<Platos> platos = new ArrayList<Platos>();
        String codigop = null;
        String nomep = null;
        
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(platosf));
        
        while (reader.hasNext()) {
            reader.next();
            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals("Plato")) {
                codigop = reader.getAttributeValue(null, "Codigop");
            }
            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                nomep = reader.getText();
                int graxaTotal = 0;
                
                BufferedReader br = new BufferedReader(new FileReader(compf));                
                String thisLine;
                while ((thisLine = br.readLine()) != null) {
                    String[] datos = thisLine.split("#");
                    if (datos[0].equals(codigop)) {
                        resultSet = st.executeQuery("select graxa from componentes where codc='"+datos[1]+"'");
                        while (resultSet.next()) {
                            graxaTotal += (resultSet.getInt(1)*Integer.parseInt(datos[2])/100);
                        }
                    }
                }
                br.close();
                                
                platos.add(new Platos(codigop, nomep, graxaTotal));
            }
        }
        
        reader.close();
        closeConexion();
        
        /*for (int i = 0; i < platos.size(); i++) {
            System.out.println(platos.get(i).toString());
        }*/
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tgraxasf));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tgraxasf));
        
        for (int i = 0; i < platos.size(); i++) {
            oos.writeObject(platos.get(i));
        }
        oos.writeObject(null);
        
        Platos plato;
        while ((plato = (Platos) ois.readObject()) != null) {
            System.out.println(plato.toString());
        }
    }
    
}
