import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        File file = new File(System.getProperty("user.dir")+"/exercicio15_XMLproba0ler/src","autores.xml");
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(file));

        while (reader.hasNext()) {
            reader.next();
            switch (reader.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    if (reader.getAttributeValue(0) == null) {
                        System.out.println("<"+reader.getLocalName()+">");
                    }
                    else {
                        System.out.println(
                                "<"+reader.getLocalName()+
                                " "+reader.getAttributeLocalName(0)+
                                "='"+reader.getAttributeValue(0)+"'>"
                        );
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println(reader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("</"+reader.getLocalName()+">");
                    break;
            }
        }
    }
}
