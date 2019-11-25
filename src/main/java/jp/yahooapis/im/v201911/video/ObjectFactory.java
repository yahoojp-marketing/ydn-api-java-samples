
package jp.yahooapis.im.v201911.video;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201911.SoapHeader;
import jp.yahooapis.im.v201911.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201911.video package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201911/Video", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201911/Video", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201911/Video", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201911.video
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
     * Create an instance of {@link UploadVideo }
     * 
     */
    public UploadVideo createUploadVideo() {
        return new UploadVideo();
    }

    /**
     * Create an instance of {@link Mutate }
     * 
     */
    public Mutate createMutate() {
        return new Mutate();
    }

    /**
     * Create an instance of {@link VideoOperation }
     * 
     */
    public VideoOperation createVideoOperation() {
        return new VideoOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link VideoPage }
     * 
     */
    public VideoPage createVideoPage() {
        return new VideoPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link VideoSelector }
     * 
     */
    public VideoSelector createVideoSelector() {
        return new VideoSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link VideoReturnValue }
     * 
     */
    public VideoReturnValue createVideoReturnValue() {
        return new VideoReturnValue();
    }

    /**
     * Create an instance of {@link GetUploadUrlResponse }
     * 
     */
    public GetUploadUrlResponse createGetUploadUrlResponse() {
        return new GetUploadUrlResponse();
    }

    /**
     * Create an instance of {@link UploadUrlPage }
     * 
     */
    public UploadUrlPage createUploadUrlPage() {
        return new UploadUrlPage();
    }

    /**
     * Create an instance of {@link UploadUrlValues }
     * 
     */
    public UploadUrlValues createUploadUrlValues() {
        return new UploadUrlValues();
    }

    /**
     * Create an instance of {@link UploadUrlValue }
     * 
     */
    public UploadUrlValue createUploadUrlValue() {
        return new UploadUrlValue();
    }

    /**
     * Create an instance of {@link VideoSetting }
     * 
     */
    public VideoSetting createVideoSetting() {
        return new VideoSetting();
    }

    /**
     * Create an instance of {@link Video }
     * 
     */
    public Video createVideo() {
        return new Video();
    }

    /**
     * Create an instance of {@link VideoValues }
     * 
     */
    public VideoValues createVideoValues() {
        return new VideoValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/Video", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/Video", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/Video", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
