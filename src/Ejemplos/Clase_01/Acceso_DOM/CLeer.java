package Ejemplos.Clase_01.Acceso_DOM;

import java.io.*;

public class CLeer {
  public static String dato() {
    String sdato = "";
    try {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }

  public static short datoShort() {
    try {
      return Short.parseShort(dato());
    } catch (NumberFormatException e) {
      return Short.MIN_VALUE; // valor mas pequeño
    }
  }

  public static int datoInt() {
    try {
      return Integer.parseInt(dato());
    } catch (NumberFormatException e) {
      return Integer.MIN_VALUE; // valor mas pequeño
    }
  }

  public static long datoLong() {
    try {
      return Long.parseLong(dato());
    } catch (NumberFormatException e) {
      return Long.MIN_VALUE; // valor mas pequeño
    }
  }

  public static float datoFloat() {
    try {
      Float f = new Float(dato());
      return f.floatValue();
    } catch (NumberFormatException e) {
      return Float.NaN; // No es un Número; valor float.
    }
  }

  public static double datoDouble() {
    try {
      Double d = new Double(dato());
      return d.doubleValue();
    } catch (NumberFormatException e) {
      return Double.NaN; // No es un Numero; valor double.
    }
  }
} // CLeer
