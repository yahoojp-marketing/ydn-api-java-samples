
package jp.yahooapis.im.v201907.feedftp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201907.SoapHeader;
import jp.yahooapis.im.v201907.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201907.feedftp package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201907/FeedFtp", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/FeedFtp", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201907/FeedFtp", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201907.feedftp
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
     * Create an instance of {@link FeedFtpOperation }
     * 
     */
    public FeedFtpOperation createFeedFtpOperation() {
        return new FeedFtpOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link FeedFtpPage }
     * 
     */
    public FeedFtpPage createFeedFtpPage() {
        return new FeedFtpPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link FeedFtpSelector }
     * 
     */
    public FeedFtpSelector createFeedFtpSelector() {
        return new FeedFtpSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link FeedFtpReturnValue }
     * 
     */
    public FeedFtpReturnValue createFeedFtpReturnValue() {
        return new FeedFtpReturnValue();
    }

    /**
     * Create an instance of {@link ScheduleWeekly }
     * 
     */
    public ScheduleWeekly createScheduleWeekly() {
        return new ScheduleWeekly();
    }

    /**
     * Create an instance of {@link FeedFtp }
     * 
     */
    public FeedFtp createFeedFtp() {
        return new FeedFtp();
    }

    /**
     * Create an instance of {@link FeedFtpValues }
     * 
     */
    public FeedFtpValues createFeedFtpValues() {
        return new FeedFtpValues();
    }

    /**
     * Create an instance of {@link Schedule }
     * 
     */
    public Schedule createSchedule() {
        return new Schedule();
    }

    /**
     * Create an instance of {@link ScheduleDaily }
     * 
     */
    public ScheduleDaily createScheduleDaily() {
        return new ScheduleDaily();
    }

    /**
     * Create an instance of {@link ScheduleHourly }
     * 
     */
    public ScheduleHourly createScheduleHourly() {
        return new ScheduleHourly();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/FeedFtp", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/FeedFtp", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201907/FeedFtp", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}