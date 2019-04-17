
package jp.yahooapis.im.v201903.adgroupad;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.im.v201903.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AdGroupAdServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd")
@XmlSeeAlso({
    jp.yahooapis.im.v201903.ObjectFactory.class,
    ObjectFactory.class
})
public interface AdGroupAdServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", className = "jp.yahooapis.im.v201903.adgroupad.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", className = "jp.yahooapis.im.v201903.adgroupad.GetResponse")
    public void get(@WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd") AdGroupAdSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", mode = WebParam.Mode.OUT) Holder<AdGroupAdPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", mode = WebParam.Mode.OUT) Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", className = "jp.yahooapis.im.v201903.adgroupad.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", className = "jp.yahooapis.im.v201903.adgroupad.MutateResponse")
    public void mutate(@WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd") AdGroupAdOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", mode = WebParam.Mode.OUT) Holder<AdGroupAdReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", mode = WebParam.Mode.OUT) Holder<List<Error>> error)
        throws ApiException
    ;

}
