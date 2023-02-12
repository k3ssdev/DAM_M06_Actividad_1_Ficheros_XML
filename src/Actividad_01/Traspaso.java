package Actividad_01;

// Importamos las clases necesarias para trabajar con archivos, creación de XML y manipulación de datos
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

// Importamos las clases generadas a partir del esquema XML
import Actividad_01.generated.Modulos;
import Actividad_01.generated.Modulos.Modulo;
import Actividad_01.generated.Modulos.Modulo.Alumno;

// Clase Traspaso para realizar la lectura de un archivo y la creación de un archivo XML
public class Traspaso {

  // ArrayList para almacenar los objetos Modulo y Alumno
  private ArrayList<Modulo> modulos = new ArrayList<Modulo>();
  private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

  // Método main que llama a los métodos leerFichero y crearXML
  public static void main(String[] args) {
    Traspaso t = new Traspaso();
    t.leerFichero();
    t.crearXML();
    System.out.println("Fichero XML creado correctamente.");
  }

  //Método que lee el fichero de texto y almacena los datos en los ArrayList modulos y alumnos.
  public void leerFichero() {
    try {
      // Crea un BufferReader para leer el fichero "src/Actividad_01/notas.txt"
      BufferedReader br = new BufferedReader(new FileReader("src/Actividad_01/notas.txt"));

      // Lee la primera línea del fichero
      String linea = br.readLine();

      // Inicializa las variables m y a a null
      Modulo m = null;
      Alumno a = null;

      // Mientras haya líneas en el fichero
      while (linea != null) {
        // Si la línea empieza con "@"
        if (linea.startsWith("@")) {
          // Separa la línea en fecha y módulo
          String[] fechaModulo = linea.substring(1).split(" ");

          // Crea un nuevo objeto Modulo y establece su curso
          m = new Modulo();
          m.setM(fechaModulo[1]);

          // Añade el objeto Modulo al ArrayList modulos, usando this para hacer referencia al objeto actual de la clase 
          this.modulos.add(m);
        }
        // Si la línea no empieza con "UF"
        else if (!linea.startsWith("UF")) {
          // Crea un nuevo objeto Alumno y establece su nombre
          a = new Alumno();
          a.setNombre(linea);

          // Si m no es null, añade el objeto Alumno a la lista de alumnos del objeto
          if (m != null) {
            // Añade el objeto Alumno al ArrayList alumnos
            m.getAlumno().add(a);
          }
        }
        // Si la línea empieza con "UF"
        else {
          // Separa la línea en nota y valor
          String[] nota = linea.split("=");

          // Si a no es null
          if (a != null) {
            // Según la nota, establece el valor correspondiente en el objeto Alumno
            switch (nota[0]) {
              case "UF1":
              // Convierte el valor de la nota a float y lo establece en el objeto Alumno
                a.setUF1(Float.parseFloat(nota[1]));
                break;
              case "UF2":
                a.setUF2(Float.parseFloat(nota[1]));
                break;
              case "UF3":
                a.setUF3(Float.parseFloat(nota[1]));
                break;
            }
          }
        }
        // Lee la siguiente línea
        linea = br.readLine();
      }
      // Cierra el BufferReader
      br.close();
    } catch (IOException e) {
      // Si ocurre un error al leer el fichero, muestra un mensaje de error
      System.out.println("Error al leer el fichero");
      e.printStackTrace();
    }
  }

  // Método que crea el archivo XML a partir de los ArrayList modulos y alumnos
  public void crearXML() {
    try {
      // Crea un objeto de la clase Modulos
      Modulos modulos = new Modulos();
      // Recorre la lista de módulos
      for (Modulo m : this.modulos) {
        // Recorre la lista de alumnos
        for (Alumno a : this.alumnos) {
          // Si el nombre del alumno es igual al módulo
          if (a.getNombre().equals(m.getM())) {
            // Agrega el alumno al módulo
            m.getAlumno().add(a);
          }
        }
        // Agrega el módulo a la lista de módulos
        modulos.getModulo().add(m);
      }
      // Crea un contexto JAXB para la clase Modulos
      JAXBContext contexto = JAXBContext.newInstance(Modulos.class);
      // Crea un objeto Marshaller para convertir el objeto Java a XML
      Marshaller marshaller = contexto.createMarshaller();
      // Establece que se formateará el XML con sangría y saltos de línea
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      // Escribe el objeto Java a un archivo XML
      marshaller.marshal(modulos, new File("src/Actividad_01/modulos.xml"));
    } catch (JAXBException e) {
      System.out.println("Error al crear el XML");
      e.printStackTrace();
    }
  }

}