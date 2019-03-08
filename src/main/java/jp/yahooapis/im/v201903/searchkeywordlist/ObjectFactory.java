
package jp.yahooapis.im.v201903.searchkeywordlist;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201903.SoapHeader;
import jp.yahooapis.im.v201903.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201903.searchkeywordlist package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/SearchKeywordList", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201903/SearchKeywordList", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201903/SearchKeywordList", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201903.searchkeywordlist
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
     * Create an instance of {@link SearchKeywordListOperation }
     * 
     */
    public SearchKeywordListOperation createSearchKeywordListOperation() {
        return new SearchKeywordListOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link SearchKeywordListPage }
     * 
     */
    public SearchKeywordListPage createSearchKeywordListPage() {
        return new SearchKeywordListPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link SearchKeywordListSelector }
     * 
     */
    public SearchKeywordListSelector createSearchKeywordListSelector() {
        return new SearchKeywordListSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link SearchKeywordListReturnValue }
     * 
     */
    public SearchKeywordListReturnValue createSearchKeywordListReturnValue() {
        return new SearchKeywordListReturnValue();
    }

    /**
     * Create an instance of {@link SearchKeywordList }
     * 
     */
    public SearchKeywordList createSearchKeywordList() {
        return new SearchKeywordList();
    }

    /**
     * Create an instance of {@link SearchKeywordListValues }
     * 
     */
    public SearchKeywordListValues createSearchKeywordListValues() {
        return new SearchKeywordListValues();
    }

    /**
     * Create an instance of {@link SearchKeyword }
     * 
     */
    public SearchKeyword createSearchKeyword() {
        return new SearchKeyword();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/SearchKeywordList", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/SearchKeywordList", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201903/SearchKeywordList", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
