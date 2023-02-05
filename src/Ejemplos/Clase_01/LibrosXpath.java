package Ejemplos.Clase_01;
//importar las clases necesarias
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

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class LibrosXpath {
    public static void main(String[] args) {
        try {
            // crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // crear un objeto DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // crear un objeto Document
            org.w3c.dom.Document document = builder.parse(new File("c:\\pruebas\\LibrosXML.xml"));
            // crear un objeto XPathFactory
            XPathFactory xPathfactory = XPathFactory.newInstance();
            // crear un objeto XPath
            XPath xpath = xPathfactory.newXPath();
            // crear un objeto XPathExpression
            XPathExpression expr = xpath.compile("//Libro");
            // crear un objeto NodeList
            NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            // recorrer el objeto NodeList
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            ex.printStackTrace(System.out);
                        
        }
    }
}
