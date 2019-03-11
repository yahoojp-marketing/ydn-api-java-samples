
package jp.yahooapis.im.v201903.dictionary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.dictionary package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/Dictionary", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/Dictionary", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/Dictionary", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.dictionary
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInterestCategoryResponse }
     * 
     */
    public GetInterestCategoryResponse createGetInterestCategoryResponse() {
        return new GetInterestCategoryResponse();
    }

    /**
     * Create an instance of {@link CategoryPage }
     * 
     */
    public CategoryPage createCategoryPage() {
        return new CategoryPage();
    }

    /**
     * Create an instance of {@link GetColorSetResponse }
     * 
     */
    public GetColorSetResponse createGetColorSetResponse() {
        return new GetColorSetResponse();
    }

    /**
     * Create an instance of {@link ColorSetPage }
     * 
     */
    public ColorSetPage createColorSetPage() {
        return new ColorSetPage();
    }

    /**
     * Create an instance of {@link GetOsVersionResponse }
     * 
     */
    public GetOsVersionResponse createGetOsVersionResponse() {
        return new GetOsVersionResponse();
    }

    /**
     * Create an instance of {@link OsVersionPage }
     * 
     */
    public OsVersionPage createOsVersionPage() {
        return new OsVersionPage();
    }

    /**
     * Create an instance of {@link GetGeographicLocation }
     * 
     */
    public GetGeographicLocation createGetGeographicLocation() {
        return new GetGeographicLocation();
    }

    /**
     * Create an instance of {@link GeographicLocationSelector }
     * 
     */
    public GeographicLocationSelector createGeographicLocationSelector() {
        return new GeographicLocationSelector();
    }

    /**
     * Create an instance of {@link GetInterestCategory }
     * 
     */
    public GetInterestCategory createGetInterestCategory() {
        return new GetInterestCategory();
    }

    /**
     * Create an instance of {@link CategorySelector }
     * 
     */
    public CategorySelector createCategorySelector() {
        return new CategorySelector();
    }

    /**
     * Create an instance of {@link GetSiteCategory }
     * 
     */
    public GetSiteCategory createGetSiteCategory() {
        return new GetSiteCategory();
    }

    /**
     * Create an instance of {@link GetColorSet }
     * 
     */
    public GetColorSet createGetColorSet() {
        return new GetColorSet();
    }

    /**
     * Create an instance of {@link ColorSetSelector }
     * 
     */
    public ColorSetSelector createColorSetSelector() {
        return new ColorSetSelector();
    }

    /**
     * Create an instance of {@link GetMediaAdFormat }
     * 
     */
    public GetMediaAdFormat createGetMediaAdFormat() {
        return new GetMediaAdFormat();
    }

    /**
     * Create an instance of {@link GetDisapprovalReasonResponse }
     * 
     */
    public GetDisapprovalReasonResponse createGetDisapprovalReasonResponse() {
        return new GetDisapprovalReasonResponse();
    }

    /**
     * Create an instance of {@link DisapprovalReasonPage }
     * 
     */
    public DisapprovalReasonPage createDisapprovalReasonPage() {
        return new DisapprovalReasonPage();
    }

    /**
     * Create an instance of {@link GetOsVersion }
     * 
     */
    public GetOsVersion createGetOsVersion() {
        return new GetOsVersion();
    }

    /**
     * Create an instance of {@link OsVersionSelector }
     * 
     */
    public OsVersionSelector createOsVersionSelector() {
        return new OsVersionSelector();
    }

    /**
     * Create an instance of {@link GetGeographicLocationResponse }
     * 
     */
    public GetGeographicLocationResponse createGetGeographicLocationResponse() {
        return new GetGeographicLocationResponse();
    }

    /**
     * Create an instance of {@link GeographicLocationPage }
     * 
     */
    public GeographicLocationPage createGeographicLocationPage() {
        return new GeographicLocationPage();
    }

    /**
     * Create an instance of {@link GetMediaAdFormatResponse }
     * 
     */
    public GetMediaAdFormatResponse createGetMediaAdFormatResponse() {
        return new GetMediaAdFormatResponse();
    }

    /**
     * Create an instance of {@link MediaAdFormatPage }
     * 
     */
    public MediaAdFormatPage createMediaAdFormatPage() {
        return new MediaAdFormatPage();
    }

    /**
     * Create an instance of {@link GetSiteCategoryResponse }
     * 
     */
    public GetSiteCategoryResponse createGetSiteCategoryResponse() {
        return new GetSiteCategoryResponse();
    }

    /**
     * Create an instance of {@link GetDisapprovalReason }
     * 
     */
    public GetDisapprovalReason createGetDisapprovalReason() {
        return new GetDisapprovalReason();
    }

    /**
     * Create an instance of {@link DisapprovalReasonSelector }
     * 
     */
    public DisapprovalReasonSelector createDisapprovalReasonSelector() {
        return new DisapprovalReasonSelector();
    }

    /**
     * Create an instance of {@link ColorSet }
     * 
     */
    public ColorSet createColorSet() {
        return new ColorSet();
    }

    /**
     * Create an instance of {@link CategoryChildValues }
     * 
     */
    public CategoryChildValues createCategoryChildValues() {
        return new CategoryChildValues();
    }

    /**
     * Create an instance of {@link MediaAdFormatValues }
     * 
     */
    public MediaAdFormatValues createMediaAdFormatValues() {
        return new MediaAdFormatValues();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link OsVersionValues }
     * 
     */
    public OsVersionValues createOsVersionValues() {
        return new OsVersionValues();
    }

    /**
     * Create an instance of {@link DisapprovalReasonValues }
     * 
     */
    public DisapprovalReasonValues createDisapprovalReasonValues() {
        return new DisapprovalReasonValues();
    }

    /**
     * Create an instance of {@link OsVersion }
     * 
     */
    public OsVersion createOsVersion() {
        return new OsVersion();
    }

    /**
     * Create an instance of {@link GeographicLocationValues }
     * 
     */
    public GeographicLocationValues createGeographicLocationValues() {
        return new GeographicLocationValues();
    }

    /**
     * Create an instance of {@link MediaAdFormat }
     * 
     */
    public MediaAdFormat createMediaAdFormat() {
        return new MediaAdFormat();
    }

    /**
     * Create an instance of {@link DisapprovalReason }
     * 
     */
    public DisapprovalReason createDisapprovalReason() {
        return new DisapprovalReason();
    }

    /**
     * Create an instance of {@link CategoryValues }
     * 
     */
    public CategoryValues createCategoryValues() {
        return new CategoryValues();
    }

    /**
     * Create an instance of {@link GeographicLocation }
     * 
     */
    public GeographicLocation createGeographicLocation() {
        return new GeographicLocation();
    }

    /**
     * Create an instance of {@link ColorSetValues }
     * 
     */
    public ColorSetValues createColorSetValues() {
        return new ColorSetValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/Dictionary", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/Dictionary", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/Dictionary", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
