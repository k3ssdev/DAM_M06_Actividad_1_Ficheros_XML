package Ejemplos.Clase_01.Acceso_DOM;
import java.io.File;

public class Principal {

    public static void main(String[] args) {
        GestionarDOM gesDOM = new GestionarDOM();
        // ruta en C:\Users\alber\OneDrive\0_INFORMATICA\DAM\M06\UF1\DAM-M06-Clase01
         File f = new File("C:\\pruebas", "LibrosXML.xml");
       // File f = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01", "LibrosXML.xml");

        if (!f.exists()) {
            System.out.println("Fichero " + f.getName() + " no existe");
        } else {
            /* Se abre el fichero XML y se crea la estructura DOM */
            gesDOM.abrir_XML_DOM(f);
            System.out.println("¡Ya se ha creado el DOM!");
            System.out.println("-------------------");

            /* Recorremos la estructura DOM y la mostramos por pantalla */
            String salida = gesDOM.recorrerDOMyMostrar();
            System.out.println("MOSTRAMOS LOS DATOS DE LA ESTRUCTURA DOM: ");
            System.out.println(salida);

            /* Pedimos los datos y añadimos un nuevo libro a la estructura DOM */
            System.out.println("\nVAMOS A AÑADIR UN LIBRO: ");
            System.out.println("Introduce el título: ");
            String titulo = CLeer.dato();
            System.out.println("Introduce el autor: ");
            String autor = CLeer.dato();
            System.out.println("Introduce el año: ");
            String anno = CLeer.dato();
            // añadimos el nodo al DOM y comprobamos si se ha añadido correctamente
            if (gesDOM.annadirDOM(titulo, autor, anno) == -1) {
                System.out.println("Error al añadir el nodo");
            } else {
                System.out.println("¡Ya se ha añadido el nodo!");
            }
            System.out.println("-------------------");

            /* Guardamos la estructura DOM a un archivo */
            System.out.println("\nVAMOS A GUARDAR LOS DATOS AL FICHERO DE SALIDA:");
            if (gesDOM.guardarDOMcomoFILE() == -1) {
                System.out.println("Error al guardar a fichero salida.xml");
            } else {
                System.out.println("¡Ya se ha creado el fichero salida.xml!");
            }
            System.out.println("-------------------");
        }
    }
}


