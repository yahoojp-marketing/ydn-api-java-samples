
package jp.yahooapis.im.v201903.conversiontracker;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.conversiontracker package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/ConversionTracker", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/ConversionTracker", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/ConversionTracker", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.conversiontracker
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mutate }
     * 
     */
    public Mutate createMutate() {
        return new Mutate();
    }

    /**
     * Create an instance of {@link ConversionTrackerOperation }
     * 
     */
    public ConversionTrackerOperation createConversionTrackerOperation() {
        return new ConversionTrackerOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link ConversionTrackerPage }
     * 
     */
    public ConversionTrackerPage createConversionTrackerPage() {
        return new ConversionTrackerPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link ConversionTrackerSelector }
     * 
     */
    public ConversionTrackerSelector createConversionTrackerSelector() {
        return new ConversionTrackerSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link ConversionTrackerReturnValue }
     * 
     */
    public ConversionTrackerReturnValue createConversionTrackerReturnValue() {
        return new ConversionTrackerReturnValue();
    }

    /**
     * Create an instance of {@link WebConversionSnippet }
     * 
     */
    public WebConversionSnippet createWebConversionSnippet() {
        return new WebConversionSnippet();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link WebConversion }
     * 
     */
    public WebConversion createWebConversion() {
        return new WebConversion();
    }

    /**
     * Create an instance of {@link AppConversion }
     * 
     */
    public AppConversion createAppConversion() {
        return new AppConversion();
    }

    /**
     * Create an instance of {@link ConversionTrackerValues }
     * 
     */
    public ConversionTrackerValues createConversionTrackerValues() {
        return new ConversionTrackerValues();
    }

    /**
     * Create an instance of {@link StatsPeriodCustomDate }
     * 
     */
    public StatsPeriodCustomDate createStatsPeriodCustomDate() {
        return new StatsPeriodCustomDate();
    }

    /**
     * Create an instance of {@link PeriodDatetime }
     * 
     */
    public PeriodDatetime createPeriodDatetime() {
        return new PeriodDatetime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/ConversionTracker", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/ConversionTracker", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/ConversionTracker", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}
