
package jp.yahooapis.im.v201812.adgroupad;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201812.SoapHeader;
import jp.yahooapis.im.v201812.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201812.adgroupad package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201812/AdGroupAd", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201812/AdGroupAd", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201812/AdGroupAd", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201812.adgroupad
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
     * Create an instance of {@link AdGroupAdOperation }
     * 
     */
    public AdGroupAdOperation createAdGroupAdOperation() {
        return new AdGroupAdOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupAdPage }
     * 
     */
    public AdGroupAdPage createAdGroupAdPage() {
        return new AdGroupAdPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupAdSelector }
     * 
     */
    public AdGroupAdSelector createAdGroupAdSelector() {
        return new AdGroupAdSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupAdReturnValue }
     * 
     */
    public AdGroupAdReturnValue createAdGroupAdReturnValue() {
        return new AdGroupAdReturnValue();
    }

    /**
     * Create an instance of {@link ManualCPVAdGroupAdBid }
     * 
     */
    public ManualCPVAdGroupAdBid createManualCPVAdGroupAdBid() {
        return new ManualCPVAdGroupAdBid();
    }

    /**
     * Create an instance of {@link Ad }
     * 
     */
    public Ad createAd() {
        return new Ad();
    }

    /**
     * Create an instance of {@link MobileAd }
     * 
     */
    public MobileAd createMobileAd() {
        return new MobileAd();
    }

    /**
     * Create an instance of {@link ResponsiveAd }
     * 
     */
    public ResponsiveAd createResponsiveAd() {
        return new ResponsiveAd();
    }

    /**
     * Create an instance of {@link TextAd }
     * 
     */
    public TextAd createTextAd() {
        return new TextAd();
    }

    /**
     * Create an instance of {@link StaticFrameAd }
     * 
     */
    public StaticFrameAd createStaticFrameAd() {
        return new StaticFrameAd();
    }

    /**
     * Create an instance of {@link AdGroupAdValues }
     * 
     */
    public AdGroupAdValues createAdGroupAdValues() {
        return new AdGroupAdValues();
    }

    /**
     * Create an instance of {@link ManualCPCAdGroupAdBid }
     * 
     */
    public ManualCPCAdGroupAdBid createManualCPCAdGroupAdBid() {
        return new ManualCPCAdGroupAdBid();
    }

    /**
     * Create an instance of {@link VideoAd }
     * 
     */
    public VideoAd createVideoAd() {
        return new VideoAd();
    }

    /**
     * Create an instance of {@link PosAd }
     * 
     */
    public PosAd createPosAd() {
        return new PosAd();
    }

    /**
     * Create an instance of {@link AdGroupAd }
     * 
     */
    public AdGroupAd createAdGroupAd() {
        return new AdGroupAd();
    }

    /**
     * Create an instance of {@link None }
     * 
     */
    public None createNone() {
        return new None();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/AdGroupAd", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/AdGroupAd", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/AdGroupAd", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
