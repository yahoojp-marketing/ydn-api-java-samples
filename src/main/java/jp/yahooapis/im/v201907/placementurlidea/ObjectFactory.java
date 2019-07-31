
package jp.yahooapis.im.v201907.placementurlidea;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201907.SoapHeader;
import jp.yahooapis.im.v201907.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201907.placementurlidea package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201907/PlacementUrlIdea", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/PlacementUrlIdea", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/PlacementUrlIdea", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201907.placementurlidea
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link PlacementUrlIdeaPage }
     * 
     */
    public PlacementUrlIdeaPage createPlacementUrlIdeaPage() {
        return new PlacementUrlIdeaPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link PlacementUrlIdeaSelector }
     * 
     */
    public PlacementUrlIdeaSelector createPlacementUrlIdeaSelector() {
        return new PlacementUrlIdeaSelector();
    }

    /**
     * Create an instance of {@link PlacementUrlIdea }
     * 
     */
    public PlacementUrlIdea createPlacementUrlIdea() {
        return new PlacementUrlIdea();
    }

    /**
     * Create an instance of {@link AdFormat }
     * 
     */
    public AdFormat createAdFormat() {
        return new AdFormat();
    }

    /**
     * Create an instance of {@link PlacementUrlIdeaValues }
     * 
     */
    public PlacementUrlIdeaValues createPlacementUrlIdeaValues() {
        return new PlacementUrlIdeaValues();
    }

    /**
     * Create an instance of {@link AdFormatConditions }
     * 
     */
    public AdFormatConditions createAdFormatConditions() {
        return new AdFormatConditions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/PlacementUrlIdea", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/PlacementUrlIdea", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/PlacementUrlIdea", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
