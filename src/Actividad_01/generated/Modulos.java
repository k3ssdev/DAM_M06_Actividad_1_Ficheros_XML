//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.11 a las 12:18:41 PM CET 
//


package Actividad_01.generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="modulo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="alumno" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="UF1" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="UF2" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="UF3" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="fecha" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "modulo"
})
@XmlRootElement(name = "modulos")
public class Modulos {

    @XmlElement(required = true)
    protected List<Modulos.Modulo> modulo;

    /**
     * Gets the value of the modulo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modulo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModulo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Modulos.Modulo }
     * 
     * 
     */
    public List<Modulos.Modulo> getModulo() {
        if (modulo == null) {
            modulo = new ArrayList<Modulos.Modulo>();
        }
        return this.modulo;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="alumno" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="UF1" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="UF2" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="UF3" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="fecha" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "alumno"
    })
    public static class Modulo {

        @XmlElement(required = true)
        protected List<Modulos.Modulo.Alumno> alumno;
        @XmlAttribute(name = "m")
        protected String m;
        @XmlAttribute(name = "fecha")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fecha;
        public String linea;

        /**
         * Gets the value of the alumno property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the alumno property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAlumno().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Modulos.Modulo.Alumno }
         * 
         * 
         */
        public List<Modulos.Modulo.Alumno> getAlumno() {
            if (alumno == null) {
                alumno = new ArrayList<Modulos.Modulo.Alumno>();
            }
            return this.alumno;
        }

        /**
         * Obtiene el valor de la propiedad m.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getM() {
            return m;
        }

        /**
         * Define el valor de la propiedad m.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setM(String value) {
            this.m = value;
        }

        /**
         * Obtiene el valor de la propiedad fecha.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFecha() {
            return fecha;
        }

        /**
         * Define el valor de la propiedad fecha.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFecha(XMLGregorianCalendar value) {
            this.fecha = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="UF1" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="UF2" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="UF3" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nombre",
            "uf1",
            "uf2",
            "uf3"
        })
        public static class Alumno {

            @XmlElement(required = true)
            protected String nombre;
            @XmlElement(name = "UF1", required = true)
            protected BigDecimal uf1;
            @XmlElement(name = "UF2", required = true)
            protected BigDecimal uf2;
            @XmlElement(name = "UF3", required = true)
            protected BigDecimal uf3;

            /**
             * Obtiene el valor de la propiedad nombre.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Define el valor de la propiedad nombre.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

            /**
             * Obtiene el valor de la propiedad uf1.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getUF1() {
                return uf1;
            }

            /**
             * Define el valor de la propiedad uf1.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setUF1(BigDecimal value) {
                this.uf1 = value;
            }

            /**
             * Obtiene el valor de la propiedad uf2.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getUF2() {
                return uf2;
            }

            /**
             * Define el valor de la propiedad uf2.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setUF2(BigDecimal value) {
                this.uf2 = value;
            }

            /**
             * Obtiene el valor de la propiedad uf3.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getUF3() {
                return uf3;
            }

            /**
             * Define el valor de la propiedad uf3.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setUF3(BigDecimal value) {
                this.uf3 = value;
            }

        }


        public void setFecha(String string) {
        }

    }

}
