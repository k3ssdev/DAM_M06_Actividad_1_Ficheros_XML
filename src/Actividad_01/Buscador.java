package Actividad_01;

// Importamos las clases necesarias para trabajar con archivos, creación de XML y manipulación de datos
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


// Clase Buscador
public class Buscador {
    // Atributos de la clase
    XPathExpression exp;
    Document XMLDoc;
    XPath xpath;

    // Método principal
    public static void main(String[] args) {
        // Crear objeto de la clase Buscador
        Buscador buscador = new Buscador();
        // Abrir fichero XML y crear DOM
        buscador.abrir_file_DOM();
        String busqueda = "/modulos/modulo/alumno[nombre='Steve Rogers']";
        // Ejecutar consulta XPath
        NodeList result = buscador.Ejecutar_XPath(busqueda); 
        // Mostrar resultado, si lo hay
        if (result != null) {
            System.out.print("\033[H\033[2J");           
            System.out.println("Busqueda: " + busqueda);
            System.out.println("");
            System.out.println(" __________________________________________________________");
            System.out.println("|      Nombre          |  Modulo   |  UF1  |  UF2  |  UF3  |");
            System.out.println("|----------------------|-----------|-------|-------|-------|");
            
            // Recorrer el NodeList y mostrar los resultados
            for (int i = 0; i < result.getLength(); i++) {
                // Obtener el nodo actual
                Node node = result.item(i);
                // Si el nodo es un elemento (no un texto)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Obtener el elemento
                    Element element = (Element) node;
                    
                    // Obtener los datos del elemento y mostrarlos
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();

                    // Obtener el valor del atributo m del elemento padre
                    String m = element.getParentNode().getAttributes().getNamedItem("m").getNodeValue();

                    // Formatear las notas a 2 decimales
                    String UF1 = String.format("%.2f", Float.parseFloat(element.getElementsByTagName("UF1").item(0).getTextContent()));
                    String UF2 = String.format("%.2f", Float.parseFloat(element.getElementsByTagName("UF2").item(0).getTextContent()));
                    String UF3 = String.format("%.2f", Float.parseFloat(element.getElementsByTagName("UF3").item(0).getTextContent()));
                    // Mostrar los datos
                    System.out.printf("| %-20s | %-9s | %-5s | %-5s | %-5s |%n", nombre, m, UF1, UF2, UF3);
                }
            }
            System.out.println("|______________________|___________|_______|_______|_______|");
            System.out.println("");
            System.out.println("Pulse una tecla para continuar...");
        
            // Esperar a que se pulse una tecla
            try {
                System.in.read();
            } catch (Exception e) {
            }
        // Mensaje de error si no se encuentra el alumno
        } else {
            System.out.println("No se encontró el alumno con nombre 'Steve Rogers'");
        }
    }

    // Método para abrir el fichero XML y crear el DOM
    public int abrir_file_DOM() {
        try {
            // crear objeto XPath y DocumentBuilderFactory para crear el DOM
            xpath = XPathFactory.newInstance().newXPath();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Abrir fichero XML
            FileInputStream fis = new FileInputStream("src/Actividad_01/modulos.xml");
            InputSource inputSource = new InputSource(fis);
            // Crear DOM
            XMLDoc = factory.newDocumentBuilder().parse(inputSource);
            return 0;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            // Devolver -1 si hay error
            return -1;
        }
    }

    // Método para ejecutar una consulta XPath
    public NodeList Ejecutar_XPath(String txtconsulta) {
        try {
            String salida="";
            // Crear objeto XPathExpression y ejecutar la consulta
            exp = xpath.compile(txtconsulta);
            // Obtener el resultado de la consulta
            Object result = exp.evaluate(XMLDoc, XPathConstants.NODESET);
            // Devolver el resultado
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                salida= salida + "\n" + nodeList.item(i).getChildNodes().item(0).getNodeValue();
            }
            return nodeList;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return null;
        }
    }
}
