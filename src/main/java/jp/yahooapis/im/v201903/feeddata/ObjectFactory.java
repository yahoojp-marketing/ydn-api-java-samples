
package jp.yahooapis.im.v201903.feeddata;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.feeddata package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedData", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedData", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedData", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.feeddata
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUploadUrl }
     * 
     */
    public GetUploadUrl createGetUploadUrl() {
        return new GetUploadUrl();
    }

    /**
     * Create an instance of {@link GetUploadStatus }
     * 
     */
    public GetUploadStatus createGetUploadStatus() {
        return new GetUploadStatus();
    }

    /**
     * Create an instance of {@link FeedDataSelector }
     * 
     */
    public FeedDataSelector createFeedDataSelector() {
        return new FeedDataSelector();
    }

    /**
     * Create an instance of {@link GetUploadUrlResponse }
     * 
     */
    public GetUploadUrlResponse createGetUploadUrlResponse() {
        return new GetUploadUrlResponse();
    }

    /**
     * Create an instance of {@link UploadUrlValue }
     * 
     */
    public UploadUrlValue createUploadUrlValue() {
        return new UploadUrlValue();
    }

    /**
     * Create an instance of {@link GetUploadStatusResponse }
     * 
     */
    public GetUploadStatusResponse createGetUploadStatusResponse() {
        return new GetUploadStatusResponse();
    }

    /**
     * Create an instance of {@link FeedDataPage }
     * 
     */
    public FeedDataPage createFeedDataPage() {
        return new FeedDataPage();
    }

    /**
     * Create an instance of {@link FileUploadDateRange }
     * 
     */
    public FileUploadDateRange createFileUploadDateRange() {
        return new FileUploadDateRange();
    }

    /**
     * Create an instance of {@link FeedDataValues }
     * 
     */
    public FeedDataValues createFeedDataValues() {
        return new FeedDataValues();
    }

    /**
     * Create an instance of {@link FeedDataRecord }
     * 
     */
    public FeedDataRecord createFeedDataRecord() {
        return new FeedDataRecord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedData", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedData", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedData", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
