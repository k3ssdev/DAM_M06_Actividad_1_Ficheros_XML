package Ejemplos.Clase_02.Cla02_accesoSAX.src;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionarSAX {

    ManejadorSAX sh;
    SAXParser parser;
    File ficheroXML;

    public int abrir_XML_SAX(File fichero) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Se crea un objeto SAXParser para interpretar el documento XML.
            parser = factory.newSAXParser();
            //Se crea un instancia del manejador que será el que recorra el documento XML secuencialmente
            sh = new ManejadorSAX();
            ficheroXML = fichero;
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String recorrerSAXyMostrar() {
        //Se da la salida al parser para que comience a manejar el documento XML que se le pasa como parámetro
        //con el manejador que también se le pasa. Esto recorrera secuencialmente el documento XML y cuando detecte
        //un comienzo o fin de elemento o un texto entonces lo tratará (según la implementación hecha del manejador)
        try {
            parser.parse(ficheroXML, sh);
            return sh.cadena_resultado;
        } catch (SAXException e) {
            e.printStackTrace();
            return "Error al parsear con SAX";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al parsear con SAX";
        }
    }

}

class ManejadorSAX extends DefaultHandler {

    int ultimoelement;
    //String publicado_en,titulo,autor;
    String cadena_resultado = "";

    public ManejadorSAX() {
        ultimoelement = 0;
    }

    //A continuación se sobrecargan los eventos de la clase DafaultHandler para recuperar el documento XML.
    //En la implementación de estos eventos se indica qué se hace cuando se encuentre el comienzo de un elemento(startElement),
    // el final de un elemento (endElement)y caracteres texto (characters)
    //Este handler detecta comienzo de un elemento, final y cadenas string (texto). 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("Libro")) {
            cadena_resultado = cadena_resultado + "Publicado en: " + atts.getValue(atts.getQName(0)) + "\n ";
            ultimoelement = 1;

        } else if (qName.equals("Titulo")) {
            ultimoelement = 2;
            cadena_resultado = cadena_resultado + "\n " + "El título es: ";
        } else if (qName.equals("Autor")) {
            ultimoelement = 3;
            cadena_resultado = cadena_resultado + "\n " + "El autor es: ";
        }
    }
    //Cuando en este ejemplo se detecta el final de un elemento <libro>, se pone un línea discontinua en la salida.

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Libro")) {
            System.out.println("He encontrado el final de un elemento, pero en este ejemplo no hago nada");
            cadena_resultado = cadena_resultado + "\n  -------------------";
        }
    }

    //Cuando se detecta una cadena de texto posterior a uno de los elementos <titulo> o <autor> entonces guarda
    //ese texto en la variable correspondiente.
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (ultimoelement == 2) {
            for (int i = start; i < length + start; i++) {
                cadena_resultado = cadena_resultado + ch[i];
            }
        } else if (ultimoelement == 3) {
            for (int i = start; i < length + start; i++) {
                cadena_resultado = cadena_resultado + ch[i];
            }
        }
    }

}
