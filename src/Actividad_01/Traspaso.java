package Actividad_01;
import Actividad_01.generated.Modulos.*;
import Actividad_01.generated.Modulos.Modulo.Alumno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Traspaso {
  private ArrayList<Modulo> modulos = new ArrayList<Modulo>();
  private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

  public void leerDatos() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("notas.txt"));
      String linea = reader.readLine();
      while (linea != null) {
        if (linea.startsWith("@")) {
          String[] partes = linea.split(" ");
          String fecha = partes[0].substring(1);
          String modulo = partes[1];
          String nombreAlumno = partes[2];

          Alumno alumno = buscarAlumno(nombreAlumno);
          if (alumno == null) {
            alumno = new Alumno();
            alumno.setNombre(nombreAlumno);
            alumnos.add(alumno);
          }

          Modulo mod = buscarModulo(modulo, fecha);
          if (mod == null) {
            mod = new Modulo();
            mod.setNombre(modulo);
            mod.setFecha(fecha);
            modulos.add(mod);
          }

          linea = reader.readLine();
          while (linea != null && !linea.startsWith("@")) {
            partes = linea.split("=");
            String nombreNota = partes[0];
            double valor = Double.parseDouble(partes[1]);

            Nota nota = new Nota(nombreNota, valor);
            mod.agregarNota(nota);
            alumno.agregarNota(nota);

            linea = reader.readLine();
          }
        }
      }
      reader.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private Alumno buscarAlumno(String nombre) {
    for (Alumno alumno : alumnos) {
      if (alumno.getNombre().equals(nombre)) {
        return alumno;
      }
    }
    return null;
  }

  private Modulo buscarModulo(String nombre, String fecha) {
    for (Modulo modulo : modulos) {
      if (modulo.getNombre().equals(nombre) && modulo.getFecha().equals(fecha)) {
        return modulo;
      }
    }
    return null;
  }
}
