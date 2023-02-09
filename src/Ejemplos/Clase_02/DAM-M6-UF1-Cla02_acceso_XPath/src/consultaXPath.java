
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class consultaXPath {
    
    
    XPathExpression exp;
    Element element;
    Document XMLDoc;
    XPath xpath;
    
    public int abrir_file_DOM()
    {
        //Abre un fichero XML para crear un DOM
        try {
            //El fichero XML que se abre es LibrosXML.xml 
            xpath = XPathFactory.newInstance().newXPath() ;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            XMLDoc = factory.newDocumentBuilder().parse(new InputSource(new
            FileInputStream("LibrosXML.xml")));
            //Al llegar aquí ya se ha creado la estructura DOM para se consultada
            return 0;
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return -1;
        }
        
    }
    public String Ejecutar_XPath(String txtconsulta)
    {
        //Ejecuta la consulta txtconsulta y devuelve el resultado como un String.
        String salida="";
        try {
             //Compila la consulta 
             exp = xpath.compile(txtconsulta);
             //Evaluate  evalua la expresión devuelta por compile y devuelve el resultado (Lista de nodos)    
             Object result=  exp.evaluate(XMLDoc, XPathConstants.NODESET);
             NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                salida = salida + "\n" + nodeList.item(i).getChildNodes().item(0).getNodeValue();
            }
            return salida;
        }
        catch (Exception ex) {
            return "Error: " + ex.toString();
        }
        
    }
    
}

