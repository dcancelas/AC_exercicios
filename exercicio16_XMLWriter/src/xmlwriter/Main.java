package xmlwriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, XMLStreamException {
        File file = new File(System.getProperty("user.dir")+"/exercicio16_XMLWriter/src", "serial");
        File xmlFile = new File(System.getProperty("user.dir")+"/exercicio16_XMLWriter/src", "products.xml");
        XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(xmlFile));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            products.add((Product) ois.readObject());
        }

        writer.writeStartDocument("1.0");
        writer.writeStartElement("products");

        for (Product product : products) {
            writer.writeStartElement("product");
            writer.writeStartElement("codigo");
            writer.writeCharacters(product.getCodigo());
            writer.writeEndElement();
            writer.writeStartElement("descricion");
            writer.writeCharacters(product.getDescricion());
            writer.writeEndElement();
            writer.writeStartElement("prezo");
            writer.writeCharacters(String.valueOf(product.getPrezo()));
            writer.writeEndElement();
            writer.writeEndElement();
        }

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.close();
    }
}
