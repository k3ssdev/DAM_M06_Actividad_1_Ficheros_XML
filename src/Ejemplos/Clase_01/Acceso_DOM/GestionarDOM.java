package Ejemplos.Clase_01.Acceso_DOM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import com.sun.org.apache.xml.internal.serialize.OutputFormat;
//import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
//import org.w3c.dom.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class GestionarDOM {

    Document doc; // Objeto Document que almacena el DOM del XML seleccionado.

    public int abrir_XML_DOM(File fichero) {
        doc = null;

        try {
            // Se crea un objeto DocumentBuiderFactory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML.
            // Es decir, cuando se convierte
            // el XML al modelo DOM los comentarios que tenga serán ignorados.
            factory.setIgnoringComments(true);
            // Ingnora los espacios en blanco. Si no se hace esto entonces los espacios en
            // blanco aparecen como nodos.
            factory.setIgnoringElementContentWhitespace(true);
            // Se crea un objeto DocumentBuilder para cargar en él la estructura de árbol
            // DOM a partir del XML seleccionado.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Interpreta (parsea) el documento XML (file) y genera el DOM equivalente.
            doc = builder.parse(fichero);
            // Ahora doc apunta al árbol DOM listo para ser recorrido.
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String recorrerDOMyMostrar() {
        String datos_nodo[] = null;
        String salida = "";
        Node node;
        // Obtiene el primero nodo del DOM
        Node raiz = doc.getFirstChild();
        // Obtiene una lista de nodos con todos los nodos hijo.
        NodeList nodelist = raiz.getChildNodes();
        for (int i = 0; i < nodelist.getLength(); i++) // Proceso los nodos hijo
        {
            node = nodelist.item(i);
            // Al ejecutar paso a paso este código, se observa como los nodos que encuentra
            // son
            // de tipo 1 (ELEMENT_NODE) y tipo 3 (TEXT_NODE). Esto es porque en DOM todo
            // elemento tiene un nodo
            // hijo TEXT aunque esté en blanco.
            if (node.getNodeType() == Node.ELEMENT_NODE) { // Es un nodo libro que hay que procesar si es de tipo
                                                           // Elemento
                datos_nodo = procesarLibro(node);
                salida = salida + "\n " + "Publicado en: " + datos_nodo[0];
                salida = salida + "\n " + "El autor es: " + datos_nodo[2];
                salida = salida + "\n " + "El título es: " + datos_nodo[1];
                salida = salida + "\n  -------------------";
            }
        }
        return salida;

    }

    protected String[] procesarLibro(Node n) {
        String datos[] = new String[3];
        Node ntemp = null;
        int contador = 1;
        // De la lista de atributos que tiene el nodo selecciona el primero (en nuestro
        // ejemplo solo hay un atributo)
        datos[0] = n.getAttributes().item(0).getNodeValue();

        // Obtiene los hijos del Libro (titulo y autor)
        NodeList nodos = n.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            ntemp = nodos.item(i);
            // Se debe comprobar el tipo de nodo que se quiere tratar por que posible que
            // haya
            // nodos tipo TEXT que contengan retornos de carro al cambiar de línea en el
            // XML.
            // En este ejemplo, cuando detecta un nodo que no es tipo ELEMENT_NODE es porque
            // es tipo TEXT
            // y contiene los retornos de carro "\n" que se incluyen en el fichero de texto
            // al crear el XML.
            if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                // IMPORTANTE: para obtener el texto con el título accede al nodo TEXT hijo de
                // ntemp y saca su valor.
                datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
                contador++;
            }

        }

        return datos;
    }

    public int guardarDOMcomoFILE() {
        try {

            /*
             * //Crea un fichero llamado salida.xml
             * File archivo_xml = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01",
             * "salida.xml");
             * //Especifica el formato de salida
             * OutputFormat format = new OutputFormat(doc);
             * //Especifica que la salida esté indentada.
             * format.setIndenting(true);
             * 
             * //Escribe el contenido en el FILE
             * XMLSerializer serializer = new XMLSerializer(new
             * FileOutputStream(archivo_xml), format);
             * serializer.serialize(doc);
             */

            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            LSSerializer serializer = impl.createLSSerializer();
            serializer.getDomConfig().setParameter("format-pretty-print", true);
            LSOutput output = impl.createLSOutput();
            OutputStream ostream = new FileOutputStream("C:\\pruebas\\salida.xml");
            output.setByteStream(ostream);
            serializer.write(doc, output);

            // Se muestra el contenido del archivo por pantalla
            /*
             * DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
             * DOMImplementationLS impl = (DOMImplementationLS)
             * registry.getDOMImplementation("XML 3.0 LS 3.0");
             * if (impl == null) {
             * System.out.println("No DOMImplementation found !");
             * System.exit(0);
             * }
             * 
             * System.out.printf("DOMImplementationLS: %s\n", impl.getClass().getName());
             * 
             * LSParser parser = impl.createLSParser(
             * DOMImplementationLS.MODE_SYNCHRONOUS,
             * "http://www.w3.org/TR/REC-xml");
             * // http://www.w3.org/2001/XMLSchema
             * System.out.printf("LSParser: %s\n", parser.getClass().getName());
             * LSSerializer lsSerializer = impl.createLSSerializer();
             * LSOutput output = impl.createLSOutput();
             * output.setEncoding("UTF-8");
             * output.setByteStream(System.out);
             * lsSerializer.write(doc, output);
             */
            return 0;
        } catch (Exception e) {

            return -1;
        }
    }

    public int annadirDOM(String titulo, String autor, String anno) {

        try {
            // Se crean los nodos en la estructura DOM apuntada por la variable doc.
            // Se crea un nodo tipo Element con nombre titulo(<titulo>)
            Node ntitulo = doc.createElement("Titulo");
            // Se crea un nodo tipo texto con el título del libro
            Node ntitulo_text = doc.createTextNode(titulo);
            // Se añade el nodo de texto con el título como hijo del elemento Titulo
            ntitulo.appendChild(ntitulo_text);
            // Se hace lo mismo que con título para autor (<autor>)
            Node nautor = doc.createElement("Autor");
            Node nautor_text = doc.createTextNode(autor);
            nautor.appendChild(nautor_text);

            // Se crea un nodo de tipo elemento (<libro>)
            Node nlibro = doc.createElement("Libro");
            // Al nuevo nodo libro se le añade un atributo publicado_en
            ((Element) nlibro).setAttribute("publicado_en", anno);

            // Se añade a libro un nodo tipo texto con un retorno de carro (\n) para que al
            // abrirlo con
            // un editor de texto cada nodo salga en un linea diferente.
            nlibro.appendChild(doc.createTextNode("\n"));
            // Se añade a libro el nodo título
            nlibro.appendChild(ntitulo);
            // Se añade también un nodo retorno de carro \n
            nlibro.appendChild(doc.createTextNode("\n"));
            // Se añade a libro el nodo autor.
            nlibro.appendChild(nautor);

            // Finalmente, se obtiene el primer nodo del documento y a él se le añade como
            // hijo el nodo libro
            // que ya tiene colgando todos sus hijos y atributos creados antes.
            Node raiz = doc.getChildNodes().item(0);
            raiz.appendChild(nlibro);

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
