
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _MalformedURLException_QNAME = new QName("http://myservice/", "MalformedURLException");
    private final static QName _IOException_QNAME = new QName("http://myservice/", "IOException");
    private final static QName _UpdateCovidWeekResponse_QNAME = new QName("http://myservice/", "UpdateCovidWeekResponse");
    private final static QName _UpdateCovidWeek_QNAME = new QName("http://myservice/", "UpdateCovidWeek");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MalformedURLException }
     * 
     */
    public MalformedURLException createMalformedURLException() {
        return new MalformedURLException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link UpdateCovidWeekResponse }
     * 
     */
    public UpdateCovidWeekResponse createUpdateCovidWeekResponse() {
        return new UpdateCovidWeekResponse();
    }

    /**
     * Create an instance of {@link UpdateCovidWeek }
     * 
     */
    public UpdateCovidWeek createUpdateCovidWeek() {
        return new UpdateCovidWeek();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MalformedURLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "MalformedURLException")
    public JAXBElement<MalformedURLException> createMalformedURLException(MalformedURLException value) {
        return new JAXBElement<MalformedURLException>(_MalformedURLException_QNAME, MalformedURLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCovidWeekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "UpdateCovidWeekResponse")
    public JAXBElement<UpdateCovidWeekResponse> createUpdateCovidWeekResponse(UpdateCovidWeekResponse value) {
        return new JAXBElement<UpdateCovidWeekResponse>(_UpdateCovidWeekResponse_QNAME, UpdateCovidWeekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCovidWeek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myservice/", name = "UpdateCovidWeek")
    public JAXBElement<UpdateCovidWeek> createUpdateCovidWeek(UpdateCovidWeek value) {
        return new JAXBElement<UpdateCovidWeek>(_UpdateCovidWeek_QNAME, UpdateCovidWeek.class, null, value);
    }

}
