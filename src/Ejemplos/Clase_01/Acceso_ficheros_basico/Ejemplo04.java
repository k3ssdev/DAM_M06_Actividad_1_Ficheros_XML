package Ejemplos.Clase_01.Acceso_ficheros_basico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;


// Ejemplo para mostrar por pantalla el contenido de un fichero que contiene texto en formato utf-8

public class Ejemplo04 {

    public static void main(String[] arg) {
        File archivo = null;
        //FileReader fr = null;
        InputStreamReader fr = null;
        BufferedReader br = null;

        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            //rula relativa a la carpeta del proyecto (src) 
            archivo = new File("src/Ejemplos/Clase_01/ficheros/", "datos.txt");
            //utf-8 es el formato de caracteres que se usa en java
            //fr = new FileReader(archivo);
            fr = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
            //bufferedreader utf-8
            br = new BufferedReader(fr);
        

            
            // Lectura del fichero con formato utf-8
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
