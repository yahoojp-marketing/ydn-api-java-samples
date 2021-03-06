
package jp.yahooapis.im.v201911.dictionary;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.im.v201911.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DictionaryServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.dictionary.ObjectFactory.class
})
public interface DictionaryServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getDisapprovalReason", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetDisapprovalReason")
    @ResponseWrapper(localName = "getDisapprovalReasonResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetDisapprovalReasonResponse")
    public void getDisapprovalReason(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        DisapprovalReasonSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<DisapprovalReasonPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getGeographicLocation", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetGeographicLocation")
    @ResponseWrapper(localName = "getGeographicLocationResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetGeographicLocationResponse")
    public void getGeographicLocation(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        GeographicLocationSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<GeographicLocationPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getInterestCategory", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetInterestCategory")
    @ResponseWrapper(localName = "getInterestCategoryResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetInterestCategoryResponse")
    public void getInterestCategory(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        CategorySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<CategoryPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getSiteCategory", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetSiteCategory")
    @ResponseWrapper(localName = "getSiteCategoryResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetSiteCategoryResponse")
    public void getSiteCategory(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        CategorySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<CategoryPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getOsVersion", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetOsVersion")
    @ResponseWrapper(localName = "getOsVersionResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetOsVersionResponse")
    public void getOsVersion(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        OsVersionSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<OsVersionPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getMediaAdFormat", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetMediaAdFormat")
    @ResponseWrapper(localName = "getMediaAdFormatResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetMediaAdFormatResponse")
    public void getMediaAdFormat(
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<MediaAdFormatPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getAudienceCategory", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetAudienceCategory")
    @ResponseWrapper(localName = "getAudienceCategoryResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetAudienceCategoryResponse")
    public void getAudienceCategory(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        CategorySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<AudienceCategoryPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getThirdPartyTrackingDomain", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetThirdPartyTrackingDomain")
    @ResponseWrapper(localName = "getThirdPartyTrackingDomainResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetThirdPartyTrackingDomainResponse")
    public void getThirdPartyTrackingDomain(
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<ThirdPartyTrackingDomainPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getFeedItemGoogleProductCategory", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetFeedItemGoogleProductCategory")
    @ResponseWrapper(localName = "getFeedItemGoogleProductCategoryResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", className = "jp.yahooapis.im.v201911.dictionary.GetFeedItemGoogleProductCategoryResponse")
    public void getFeedItemGoogleProductCategory(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary")
        FeedItemGoogleProductCategorySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<FeedItemGoogleProductCategoryPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Dictionary", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
