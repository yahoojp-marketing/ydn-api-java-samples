
package jp.yahooapis.im.v201907.adgroup;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201907.SoapHeader;
import jp.yahooapis.im.v201907.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201907.adgroup package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/AdGroup", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201907/AdGroup", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/AdGroup", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201907.adgroup
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
     * Create an instance of {@link AdGroupOperation }
     * 
     */
    public AdGroupOperation createAdGroupOperation() {
        return new AdGroupOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupPage }
     * 
     */
    public AdGroupPage createAdGroupPage() {
        return new AdGroupPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupSelector }
     * 
     */
    public AdGroupSelector createAdGroupSelector() {
        return new AdGroupSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupReturnValue }
     * 
     */
    public AdGroupReturnValue createAdGroupReturnValue() {
        return new AdGroupReturnValue();
    }

    /**
     * Create an instance of {@link NoneAdGroupConversionOptimizer }
     * 
     */
    public NoneAdGroupConversionOptimizer createNoneAdGroupConversionOptimizer() {
        return new NoneAdGroupConversionOptimizer();
    }

    /**
     * Create an instance of {@link ManualCPCAdGroupBid }
     * 
     */
    public ManualCPCAdGroupBid createManualCPCAdGroupBid() {
        return new ManualCPCAdGroupBid();
    }

    /**
     * Create an instance of {@link ManualAdGroupConversionOptimizer }
     * 
     */
    public ManualAdGroupConversionOptimizer createManualAdGroupConversionOptimizer() {
        return new ManualAdGroupConversionOptimizer();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link AdGroup }
     * 
     */
    public AdGroup createAdGroup() {
        return new AdGroup();
    }

    /**
     * Create an instance of {@link AdGroupConversionOptimizer }
     * 
     */
    public AdGroupConversionOptimizer createAdGroupConversionOptimizer() {
        return new AdGroupConversionOptimizer();
    }

    /**
     * Create an instance of {@link AutoAdGroupConversionOptimizer }
     * 
     */
    public AutoAdGroupConversionOptimizer createAutoAdGroupConversionOptimizer() {
        return new AutoAdGroupConversionOptimizer();
    }

    /**
     * Create an instance of {@link AdGroupValues }
     * 
     */
    public AdGroupValues createAdGroupValues() {
        return new AdGroupValues();
    }

    /**
     * Create an instance of {@link ManualCPVAdGroupBid }
     * 
     */
    public ManualCPVAdGroupBid createManualCPVAdGroupBid() {
        return new ManualCPVAdGroupBid();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AdGroup", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AdGroup", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AdGroup", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
