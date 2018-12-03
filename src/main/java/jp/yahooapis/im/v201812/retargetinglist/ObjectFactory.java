
package jp.yahooapis.im.v201812.retargetinglist;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.im.v201812.SoapHeader;
import jp.yahooapis.im.v201812.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.v201812.retargetinglist package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V201812/RetargetingList", "ResponseHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V201812/RetargetingList", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V201812/RetargetingList", "RequestHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.v201812.retargetinglist
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
     * Create an instance of {@link RetargetingListOperation }
     * 
     */
    public RetargetingListOperation createRetargetingListOperation() {
        return new RetargetingListOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link RetargetingListPage }
     * 
     */
    public RetargetingListPage createRetargetingListPage() {
        return new RetargetingListPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link RetargetingListSelector }
     * 
     */
    public RetargetingListSelector createRetargetingListSelector() {
        return new RetargetingListSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link RetargetingListReturnValue }
     * 
     */
    public RetargetingListReturnValue createRetargetingListReturnValue() {
        return new RetargetingListReturnValue();
    }

    /**
     * Create an instance of {@link SimilarityTargetList }
     * 
     */
    public SimilarityTargetList createSimilarityTargetList() {
        return new SimilarityTargetList();
    }

    /**
     * Create an instance of {@link RetargetingListValues }
     * 
     */
    public RetargetingListValues createRetargetingListValues() {
        return new RetargetingListValues();
    }

    /**
     * Create an instance of {@link TargetListSizeReaches }
     * 
     */
    public TargetListSizeReaches createTargetListSizeReaches() {
        return new TargetListSizeReaches();
    }

    /**
     * Create an instance of {@link Combination }
     * 
     */
    public Combination createCombination() {
        return new Combination();
    }

    /**
     * Create an instance of {@link RuleTargetList }
     * 
     */
    public RuleTargetList createRuleTargetList() {
        return new RuleTargetList();
    }

    /**
     * Create an instance of {@link RuleCondition }
     * 
     */
    public RuleCondition createRuleCondition() {
        return new RuleCondition();
    }

    /**
     * Create an instance of {@link RetargetingList }
     * 
     */
    public RetargetingList createRetargetingList() {
        return new RetargetingList();
    }

    /**
     * Create an instance of {@link CombinationTargetList }
     * 
     */
    public CombinationTargetList createCombinationTargetList() {
        return new CombinationTargetList();
    }

    /**
     * Create an instance of {@link TargetListData }
     * 
     */
    public TargetListData createTargetListData() {
        return new TargetListData();
    }

    /**
     * Create an instance of {@link CustomAudienceTargetList }
     * 
     */
    public CustomAudienceTargetList createCustomAudienceTargetList() {
        return new CustomAudienceTargetList();
    }

    /**
     * Create an instance of {@link Rule }
     * 
     */
    public Rule createRule() {
        return new Rule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/RetargetingList", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/RetargetingList", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V201812/RetargetingList", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

}
