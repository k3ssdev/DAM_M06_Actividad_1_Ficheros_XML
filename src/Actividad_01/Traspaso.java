package Actividad_01;

import Actividad_01.generated.Modulos.Modulo.Alumno;
import Actividad_01.generated.Modulos.Modulo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Traspaso  {

  public static void main(String[] args) {
    Traspaso traspaso = new Traspaso();
    traspaso.leerDatos();
  }

  private ArrayList<Modulo> modulos = new ArrayList<Modulo>();
  private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

  public void leerDatos()  {
    try {
      BufferedReader br = new BufferedReader(new FileReader("src/Actividad_01/notas.txt"));
      String line;
            
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    String[] datos = line.split(" ");
                    
                    // Crear el módulo
                    Modulo modulo = new Modulo();
                    //quitar el @ a la fecha
                    datos[0] = datos[0].substring(1);
                    System.out.println("Fecha: " + datos[0]);
                    System.out.println("Modulo: " + datos[1]);
                    
                    // Añadir el módulo a la lista
                    modulos.add(modulo);
                } else if (line.startsWith("UF")) {
                    String[] datos = line.split("=");
                    
                    // Crear la UF
                    Modulo uf1Modulo = new Modulo();
                    System.out.println("UF: " + datos[0]);
                    System.out.println("Nota: " + datos[1]);
                    
                    // Añadir la UF al módulo
                    modulos.add(uf1Modulo);
                } else {
                    String[] datos = line.split("");
                    
                    // Crear el alumno
                    Alumno alumno = new Alumno();
                    System.out.println("Nombre: " + datos[0]);
                    // Añadir el alumno a la lista
                    alumnos.add(alumno);
                }
            }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}