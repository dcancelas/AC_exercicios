import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, XMLStreamException {
        File file = new File(System.getProperty("user.dir")+"/exercicio14_XMLproba0/src","autores.xml");
        XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(file));

        writer.writeStartDocument("1.0");
        writer.writeStartElement("autores");

        writer.writeStartElement("autor");
        writer.writeAttribute("codigo","a1");

        writer.writeStartElement("nome");
        writer.writeCharacters("Alexandre Dumas");
        writer.writeEndElement();
        writer.writeStartElement("titulo");
        writer.writeCharacters("El conde de montecristo");
        writer.writeEndElement();
        writer.writeStartElement("titulo");
        writer.writeCharacters("Los miserables");
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeStartElement("autor");
        writer.writeAttribute("codigo","a2");

        writer.writeStartElement("nome");
        writer.writeCharacters("Fiodor Dostoyevski");
        writer.writeEndElement();
        writer.writeStartElement("titulo");
        writer.writeCharacters("El idiota");
        writer.writeEndElement();
        writer.writeStartElement("titulo");
        writer.writeCharacters("Noches blancas");
        writer.writeEndElement();

        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.close();
    }
}
