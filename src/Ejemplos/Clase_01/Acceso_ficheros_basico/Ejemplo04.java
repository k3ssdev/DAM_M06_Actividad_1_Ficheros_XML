package Ejemplos.Clase_01.Acceso_ficheros_basico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// Ejemplo para mostrar por pantalla el contenido de un fichero

public class Ejemplo04 {

    public static void main(String[] arg) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01", "ejemplo04.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
