
import java.io.File;

public class Principal {

    public static void main(String[] args) {
        GestionarSAX gesSAX = new GestionarSAX();
        File f = new File("G:\\La meva unitat\\DAM-M06\\Clase02", "LibrosXML.xml");

        if (!f.exists()) {
            System.out.println("Fichero " + f.getName() + " no existe");
        } else if (gesSAX.abrir_XML_SAX(f) == -1) {
            System.out.println("Error al abrir el archivo para SAX");
        } else {
            System.out.println("¡Ya se ha creado el SAX!");
            System.out.println("-------------------");

            String salida = gesSAX.recorrerSAXyMostrar();
            System.out.println("-------------------");
            System.out.println("MOSTRAMOS LOS DATOS DE LA ESTRUCTURA SAX: ");
            System.out.println(salida);
        }
    }
}
