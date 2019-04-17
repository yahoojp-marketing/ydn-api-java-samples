
package jp.yahooapis.im.v201903.feedset;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.feedset package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedSet", "ResponseHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedSet", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedSet", "RequestHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.feedset
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
     * Create an instance of {@link FeedSetOperation }
     * 
     */
    public FeedSetOperation createFeedSetOperation() {
        return new FeedSetOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link FeedSetPage }
     * 
     */
    public FeedSetPage createFeedSetPage() {
        return new FeedSetPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link FeedSetSelector }
     * 
     */
    public FeedSetSelector createFeedSetSelector() {
        return new FeedSetSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link FeedSetReturnValue }
     * 
     */
    public FeedSetReturnValue createFeedSetReturnValue() {
        return new FeedSetReturnValue();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link ConditionSet }
     * 
     */
    public ConditionSet createConditionSet() {
        return new ConditionSet();
    }

    /**
     * Create an instance of {@link FeedSetValues }
     * 
     */
    public FeedSetValues createFeedSetValues() {
        return new FeedSetValues();
    }

    /**
     * Create an instance of {@link FeedSet }
     * 
     */
    public FeedSet createFeedSet() {
        return new FeedSet();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedSet", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedSet", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/FeedSet", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

}
