package Ejemplos.Clase_01.Acceso_ficheros_basico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

// Ejemplo para escribir en un fichero

public class Ejemplo03 {

    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        File f = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01", "ejemplo03.txt");
        System.out.println(f.getAbsolutePath());
        try {
            fichero = new FileWriter(f);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
           // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* Scanner entrada = new Scanner(System.in);
        String s;
        BufferedWriter escriptor = null;

        try {

            System.out.println("Nombre del fichero: ");
            String nomFitxer = entrada.next();

            escriptor = new BufferedWriter(new FileWriter("/Volumes/Dades/linkiaFP/DAM-M06/Clase01" + nomFitxer));
            System.out.println("Introduce texto: ");

            while (!(s = entrada.nextLine()).equals("end")) {
                escriptor.write(s);		//Escribe una linea
                escriptor.newLine();            //Escribe un salto de linea
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escriptor != null) {
                try {
                    escriptor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
