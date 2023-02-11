package Ejemplos.Clase_02.Cla02_marshall_ant.src;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import Ejemplos.generated.Modulos;
import Ejemplos.generated.Modulos.Modulo;
import Ejemplos.generated.Modulos.Modulo.Alumno;

public class Aplicacion {

    public static void main(String args[]) {
        try {
            Modulos modulos = new Modulos();

            float uf1 = (float)1.0;
            float uf2 = (float)2.0;
            float uf3 = (float)3.0;
            
            Alumno alumno = new Alumno();
            alumno.setNombre("Juan");
            alumno.setUF1(uf1);
            alumno.setUF2(uf2);
            alumno.setUF3(uf3);
            
            Alumno alumno2 = new Alumno();
            alumno2.setUF1(uf1+1);
            alumno2.setUF2(uf2+2);
            alumno2.setUF3(uf3+3);
            
            Modulo modulo = new Modulo();
            alumno.setNombre("Pedro");
            modulo.getAlumno().add(alumno);
            modulo.getAlumno().add(alumno2);
            modulo.setM("M01");
            
            Modulo modulo1 = new Modulo();
            modulo1.getAlumno().add(alumno2);
            modulo1.getAlumno().add(alumno);
            modulo1.setM("M02");
            
            modulos.getModulo().add(modulo);
            modulos.getModulo().add(modulo1);

            // Creamos el contexto JAXBContext para nuestra clase incidencias
            JAXBContext contexto = JAXBContext.newInstance(Modulos.class);
            // Declaramos el serializador
            Marshaller m = contexto.createMarshaller();
            // Fichero que vamos a generar
            File f = new File("modulos.xml");
            // Con esta propiedad hacemos que escriba el texto con formato xml, en vez de todo en una línea
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Escribimos el xml en el fichero
            m.marshal(modulos, f);
        } catch (Exception e) {

        }
    }
}
