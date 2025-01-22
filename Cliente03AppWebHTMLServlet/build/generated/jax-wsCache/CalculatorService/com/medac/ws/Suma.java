
package com.medac.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para suma complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="suma">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="val1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="val2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "suma", propOrder = {
    "val1",
    "val2"
})
public class Suma {

    protected double val1;
    protected double val2;

    /**
     * Obtiene el valor de la propiedad val1.
     * 
     */
    public double getVal1() {
        return val1;
    }

    /**
     * Define el valor de la propiedad val1.
     * 
     */
    public void setVal1(double value) {
        this.val1 = value;
    }

    /**
     * Obtiene el valor de la propiedad val2.
     * 
     */
    public double getVal2() {
        return val2;
    }

    /**
     * Define el valor de la propiedad val2.
     * 
     */
    public void setVal2(double value) {
        this.val2 = value;
    }

}
