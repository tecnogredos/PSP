
package com.medac.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.medac.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Divide_QNAME = new QName("http://ws.medac.com/", "divide");
    private final static QName _DivideResponse_QNAME = new QName("http://ws.medac.com/", "divideResponse");
    private final static QName _Resta_QNAME = new QName("http://ws.medac.com/", "resta");
    private final static QName _RestaResponse_QNAME = new QName("http://ws.medac.com/", "restaResponse");
    private final static QName _Suma_QNAME = new QName("http://ws.medac.com/", "suma");
    private final static QName _SumaResponse_QNAME = new QName("http://ws.medac.com/", "sumaResponse");
    private final static QName _Potencia_QNAME = new QName("http://ws.medac.com/", "potencia");
    private final static QName _PotenciaResponse_QNAME = new QName("http://ws.medac.com/", "potenciaResponse");
    private final static QName _Multiplica_QNAME = new QName("http://ws.medac.com/", "multiplica");
    private final static QName _MultiplicaResponse_QNAME = new QName("http://ws.medac.com/", "multiplicaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.medac.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Suma }
     * 
     */
    public Suma createSuma() {
        return new Suma();
    }

    /**
     * Create an instance of {@link SumaResponse }
     * 
     */
    public SumaResponse createSumaResponse() {
        return new SumaResponse();
    }

    /**
     * Create an instance of {@link Potencia }
     * 
     */
    public Potencia createPotencia() {
        return new Potencia();
    }

    /**
     * Create an instance of {@link PotenciaResponse }
     * 
     */
    public PotenciaResponse createPotenciaResponse() {
        return new PotenciaResponse();
    }

    /**
     * Create an instance of {@link Multiplica }
     * 
     */
    public Multiplica createMultiplica() {
        return new Multiplica();
    }

    /**
     * Create an instance of {@link MultiplicaResponse }
     * 
     */
    public MultiplicaResponse createMultiplicaResponse() {
        return new MultiplicaResponse();
    }

    /**
     * Create an instance of {@link Divide }
     * 
     */
    public Divide createDivide() {
        return new Divide();
    }

    /**
     * Create an instance of {@link DivideResponse }
     * 
     */
    public DivideResponse createDivideResponse() {
        return new DivideResponse();
    }

    /**
     * Create an instance of {@link Resta }
     * 
     */
    public Resta createResta() {
        return new Resta();
    }

    /**
     * Create an instance of {@link RestaResponse }
     * 
     */
    public RestaResponse createRestaResponse() {
        return new RestaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Divide }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "divide")
    public JAXBElement<Divide> createDivide(Divide value) {
        return new JAXBElement<Divide>(_Divide_QNAME, Divide.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "divideResponse")
    public JAXBElement<DivideResponse> createDivideResponse(DivideResponse value) {
        return new JAXBElement<DivideResponse>(_DivideResponse_QNAME, DivideResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "resta")
    public JAXBElement<Resta> createResta(Resta value) {
        return new JAXBElement<Resta>(_Resta_QNAME, Resta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "restaResponse")
    public JAXBElement<RestaResponse> createRestaResponse(RestaResponse value) {
        return new JAXBElement<RestaResponse>(_RestaResponse_QNAME, RestaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suma }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "suma")
    public JAXBElement<Suma> createSuma(Suma value) {
        return new JAXBElement<Suma>(_Suma_QNAME, Suma.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "sumaResponse")
    public JAXBElement<SumaResponse> createSumaResponse(SumaResponse value) {
        return new JAXBElement<SumaResponse>(_SumaResponse_QNAME, SumaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Potencia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "potencia")
    public JAXBElement<Potencia> createPotencia(Potencia value) {
        return new JAXBElement<Potencia>(_Potencia_QNAME, Potencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PotenciaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "potenciaResponse")
    public JAXBElement<PotenciaResponse> createPotenciaResponse(PotenciaResponse value) {
        return new JAXBElement<PotenciaResponse>(_PotenciaResponse_QNAME, PotenciaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "multiplica")
    public JAXBElement<Multiplica> createMultiplica(Multiplica value) {
        return new JAXBElement<Multiplica>(_Multiplica_QNAME, Multiplica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplicaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.medac.com/", name = "multiplicaResponse")
    public JAXBElement<MultiplicaResponse> createMultiplicaResponse(MultiplicaResponse value) {
        return new JAXBElement<MultiplicaResponse>(_MultiplicaResponse_QNAME, MultiplicaResponse.class, null, value);
    }

}
