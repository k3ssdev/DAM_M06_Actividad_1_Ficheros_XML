package Actividad_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


// Ejemplo para mostrar por pantalla el contenido de un fichero que contiene texto en formato utf-8

public class Traspaso {

    public static void main(String[] arg) {
        File archivo = null;
        InputStreamReader fr = null;
        BufferedReader br = null;

        //Cadena con el directorio actual
        String currentDir = System.getProperty("user.dir");

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(currentDir + "/src/Actividad_01/notas.txt");
            // Inicializamos el lector de ficheros con el formato utf-8, usando el constructor de InputStreamReader que recibe un FileInputStream
            fr = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
            // Inicializamos el buffer de lectura con el lector de ficheros
            br = new BufferedReader(fr);
        
            
            // Estrucutra de control para leer el fichero linea a linea usando el metodo readLine()
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
