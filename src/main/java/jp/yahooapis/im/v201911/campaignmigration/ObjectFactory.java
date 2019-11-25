
package jp.yahooapis.im.v201911.campaignmigration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201911.SoapHeader;
import jp.yahooapis.im.v201911.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201911.campaignmigration package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201911/CampaignMigration", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201911/CampaignMigration", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201911/CampaignMigration", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201911.campaignmigration
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
     * Create an instance of {@link CampaignUploadSelector }
     * 
     */
    public CampaignUploadSelector createCampaignUploadSelector() {
        return new CampaignUploadSelector();
    }

    /**
     * Create an instance of {@link GetMigrationStatusResponse }
     * 
     */
    public GetMigrationStatusResponse createGetMigrationStatusResponse() {
        return new GetMigrationStatusResponse();
    }

    /**
     * Create an instance of {@link MigrationStatusPage }
     * 
     */
    public MigrationStatusPage createMigrationStatusPage() {
        return new MigrationStatusPage();
    }

    /**
     * Create an instance of {@link GetMigrationStatus }
     * 
     */
    public GetMigrationStatus createGetMigrationStatus() {
        return new GetMigrationStatus();
    }

    /**
     * Create an instance of {@link MigrationStatusSelector }
     * 
     */
    public MigrationStatusSelector createMigrationStatusSelector() {
        return new MigrationStatusSelector();
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
     * Create an instance of {@link GetCampaignDownloadUrlResponse }
     * 
     */
    public GetCampaignDownloadUrlResponse createGetCampaignDownloadUrlResponse() {
        return new GetCampaignDownloadUrlResponse();
    }

    /**
     * Create an instance of {@link CampaignDownloadUrlValue }
     * 
     */
    public CampaignDownloadUrlValue createCampaignDownloadUrlValue() {
        return new CampaignDownloadUrlValue();
    }

    /**
     * Create an instance of {@link GetCampaignDownloadUrl }
     * 
     */
    public GetCampaignDownloadUrl createGetCampaignDownloadUrl() {
        return new GetCampaignDownloadUrl();
    }

    /**
     * Create an instance of {@link CampaignDownloadSelector }
     * 
     */
    public CampaignDownloadSelector createCampaignDownloadSelector() {
        return new CampaignDownloadSelector();
    }

    /**
     * Create an instance of {@link MigrationJobValues }
     * 
     */
    public MigrationJobValues createMigrationJobValues() {
        return new MigrationJobValues();
    }

    /**
     * Create an instance of {@link MigrationJob }
     * 
     */
    public MigrationJob createMigrationJob() {
        return new MigrationJob();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/CampaignMigration", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/CampaignMigration", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201911/CampaignMigration", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
