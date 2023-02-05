package Ejemplos.Clase_01.Acceso_ficheros_basico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// Ejemplo para leer el contenido de un fichero y copiarlo en otro fichero

public class Ejemplo05 {
    public static void main(String [] arg) {
      File fin = null;
      FileReader fr = null;
      BufferedReader br = null;
      
      File fout = null;
      FileWriter fw = null;
      PrintWriter pw = null;

      try {
         fin = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01", "ejemplo04.txt");
         fr = new FileReader (fin);
         br = new BufferedReader(fr);
         
         fout = new File("/Volumes/Dades/linkiaFP-MAC/DAM-M06/Clase01", "ejemplo05.txt");
         fw = new FileWriter(fout);
         pw = new PrintWriter(fw);

        String linea;
         while((linea=br.readLine())!=null){
             pw.println(linea);
         } 
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();
               fw.close();
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
}
