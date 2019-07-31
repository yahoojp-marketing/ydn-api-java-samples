
package jp.yahooapis.im.v201907.auditlog;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201907.SoapHeader;
import jp.yahooapis.im.v201907.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201907.auditlog package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/AuditLog", "ResponseHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201907/AuditLog", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/AuditLog", "RequestHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201907.auditlog
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDownloadStatusResponse }
     * 
     */
    public GetDownloadStatusResponse createGetDownloadStatusResponse() {
        return new GetDownloadStatusResponse();
    }

    /**
     * Create an instance of {@link AuditLogDownloadStatusPage }
     * 
     */
    public AuditLogDownloadStatusPage createAuditLogDownloadStatusPage() {
        return new AuditLogDownloadStatusPage();
    }

    /**
     * Create an instance of {@link GetDownloadResponse }
     * 
     */
    public GetDownloadResponse createGetDownloadResponse() {
        return new GetDownloadResponse();
    }

    /**
     * Create an instance of {@link AuditLogDownloadReturnValue }
     * 
     */
    public AuditLogDownloadReturnValue createAuditLogDownloadReturnValue() {
        return new AuditLogDownloadReturnValue();
    }

    /**
     * Create an instance of {@link GetDownload }
     * 
     */
    public GetDownload createGetDownload() {
        return new GetDownload();
    }

    /**
     * Create an instance of {@link AuditLogDownloadSelector }
     * 
     */
    public AuditLogDownloadSelector createAuditLogDownloadSelector() {
        return new AuditLogDownloadSelector();
    }

    /**
     * Create an instance of {@link GetDownloadStatus }
     * 
     */
    public GetDownloadStatus createGetDownloadStatus() {
        return new GetDownloadStatus();
    }

    /**
     * Create an instance of {@link AuditLogDownloadStatusSelector }
     * 
     */
    public AuditLogDownloadStatusSelector createAuditLogDownloadStatusSelector() {
        return new AuditLogDownloadStatusSelector();
    }

    /**
     * Create an instance of {@link AuditLogDownloadValues }
     * 
     */
    public AuditLogDownloadValues createAuditLogDownloadValues() {
        return new AuditLogDownloadValues();
    }

    /**
     * Create an instance of {@link AuditLogJob }
     * 
     */
    public AuditLogJob createAuditLogJob() {
        return new AuditLogJob();
    }

    /**
     * Create an instance of {@link AuditLogDateRange }
     * 
     */
    public AuditLogDateRange createAuditLogDateRange() {
        return new AuditLogDateRange();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AuditLog", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AuditLog", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/AuditLog", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

}
