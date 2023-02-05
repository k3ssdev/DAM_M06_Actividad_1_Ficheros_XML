package Ejemplos.Clase_01.Acceso_DOM;
//Importamos las librerías necesarias
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

//Clase principal
public class LibrosXpath2 {
    //Método principal
    public static void main(String[] args) {
        LibrosXpath2 lx = new LibrosXpath2();
        lx.leerXML();
    }
    //Variables globales de la clase principal LibrosXpath2 
    XPathExpression exp;
    Element element;
    Document XMLDoc;
    XPath xpath;

    //Método para leer el archivo XML
    public void leerXML() {
        //Bloque try-catch para capturar las excepciones
        try {
            // crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // crear un objeto DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // crear un objeto Document y parsear el archivo XML
            XMLDoc = builder.parse(new File("c:\\pruebas\\LibrosXML.xml"));
            // crear un objeto XPathFactory y un objeto XPath
            xpath = XPathFactory.newInstance().newXPath();
            // crear un objeto XPathExpression y evaluar el documento XML
            exp = xpath.compile("//Libro");
            // crear un objeto NodeList y recorrerlo
            NodeList nodeList = (NodeList) exp.evaluate(XMLDoc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Mostrar el contenido del nodo Libro en la posición i del NodeList
                System.out.println(nodeList.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
