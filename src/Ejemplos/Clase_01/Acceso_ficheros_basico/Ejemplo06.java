package Ejemplos.Clase_01.Acceso_ficheros_basico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejemplo06 {
    public static void main(String[] args) {
        // Asignamos los dos archivos de datos (el origen y el destino)
        File fIn = new File("../../entrada.txt");
        File fOut = new File("../../salida.txt");
        
        // Comprobamos que exista el archivo de origen
        if (!fIn.exists()) {
            System.err.println("El archivo no existe.Acabamos");
            System.exit(-1);
        }
        
        try {
            // Definimos los dos canales (entrada y salida)
            BufferedReader in = new BufferedReader(new FileReader(fIn));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fOut)));
            
            int nl = 1;
            String linea;

            // Leemos del archivo fuente línea a línea
            while((linea = in.readLine()) != null) {
                // Grabamos la línea con el número de línea añadido
                String lineaOut = nl + " " + linea;
                out.println(lineaOut);
                nl++;
            }
            
            // Cerramos educadamente los canales antes de acabar
            in.close();
            out.close();
            System.out.println("Programa finalizado");
            System.exit(0);
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }
}

