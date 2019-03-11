
package jp.yahooapis.im.v201903.adgrouptarget;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.adgrouptarget package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/AdGroupTarget", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/AdGroupTarget", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/AdGroupTarget", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.adgrouptarget
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
     * Create an instance of {@link AdGroupTargetMutateOperation }
     * 
     */
    public AdGroupTargetMutateOperation createAdGroupTargetMutateOperation() {
        return new AdGroupTargetMutateOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupTargetPage }
     * 
     */
    public AdGroupTargetPage createAdGroupTargetPage() {
        return new AdGroupTargetPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupTargetSelector }
     * 
     */
    public AdGroupTargetSelector createAdGroupTargetSelector() {
        return new AdGroupTargetSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupTargetReturnValue }
     * 
     */
    public AdGroupTargetReturnValue createAdGroupTargetReturnValue() {
        return new AdGroupTargetReturnValue();
    }

    /**
     * Create an instance of {@link Replace }
     * 
     */
    public Replace createReplace() {
        return new Replace();
    }

    /**
     * Create an instance of {@link AdGroupTargetOperation }
     * 
     */
    public AdGroupTargetOperation createAdGroupTargetOperation() {
        return new AdGroupTargetOperation();
    }

    /**
     * Create an instance of {@link ReplaceResponse }
     * 
     */
    public ReplaceResponse createReplaceResponse() {
        return new ReplaceResponse();
    }

    /**
     * Create an instance of {@link DeviceTarget }
     * 
     */
    public DeviceTarget createDeviceTarget() {
        return new DeviceTarget();
    }

    /**
     * Create an instance of {@link PlacementTarget }
     * 
     */
    public PlacementTarget createPlacementTarget() {
        return new PlacementTarget();
    }

    /**
     * Create an instance of {@link AdScheduleTarget }
     * 
     */
    public AdScheduleTarget createAdScheduleTarget() {
        return new AdScheduleTarget();
    }

    /**
     * Create an instance of {@link Target }
     * 
     */
    public Target createTarget() {
        return new Target();
    }

    /**
     * Create an instance of {@link AdGroupTarget }
     * 
     */
    public AdGroupTarget createAdGroupTarget() {
        return new AdGroupTarget();
    }

    /**
     * Create an instance of {@link SearchTarget }
     * 
     */
    public SearchTarget createSearchTarget() {
        return new SearchTarget();
    }

    /**
     * Create an instance of {@link GenderTarget }
     * 
     */
    public GenderTarget createGenderTarget() {
        return new GenderTarget();
    }

    /**
     * Create an instance of {@link AgeTarget }
     * 
     */
    public AgeTarget createAgeTarget() {
        return new AgeTarget();
    }

    /**
     * Create an instance of {@link OsVersionTarget }
     * 
     */
    public OsVersionTarget createOsVersionTarget() {
        return new OsVersionTarget();
    }

    /**
     * Create an instance of {@link GeoTarget }
     * 
     */
    public GeoTarget createGeoTarget() {
        return new GeoTarget();
    }

    /**
     * Create an instance of {@link InterestCategoryTarget }
     * 
     */
    public InterestCategoryTarget createInterestCategoryTarget() {
        return new InterestCategoryTarget();
    }

    /**
     * Create an instance of {@link CarrierTarget }
     * 
     */
    public CarrierTarget createCarrierTarget() {
        return new CarrierTarget();
    }

    /**
     * Create an instance of {@link AdGroupTargetValue }
     * 
     */
    public AdGroupTargetValue createAdGroupTargetValue() {
        return new AdGroupTargetValue();
    }

    /**
     * Create an instance of {@link AppTarget }
     * 
     */
    public AppTarget createAppTarget() {
        return new AppTarget();
    }

    /**
     * Create an instance of {@link SiteCategoryTarget }
     * 
     */
    public SiteCategoryTarget createSiteCategoryTarget() {
        return new SiteCategoryTarget();
    }

    /**
     * Create an instance of {@link OsTarget }
     * 
     */
    public OsTarget createOsTarget() {
        return new OsTarget();
    }

    /**
     * Create an instance of {@link SiteRetargetingTarget }
     * 
     */
    public SiteRetargetingTarget createSiteRetargetingTarget() {
        return new SiteRetargetingTarget();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/AdGroupTarget", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/AdGroupTarget", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/AdGroupTarget", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
