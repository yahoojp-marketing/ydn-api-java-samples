
package jp.yahooapis.im.v201911.adgroup;

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
@WebService(name = "AdGroupServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.adgroup.ObjectFactory.class
})
public interface AdGroupServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", className = "jp.yahooapis.im.v201911.adgroup.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", className = "jp.yahooapis.im.v201911.adgroup.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup")
        AdGroupSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", mode = WebParam.Mode.OUT)
        Holder<AdGroupPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", className = "jp.yahooapis.im.v201911.adgroup.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", className = "jp.yahooapis.im.v201911.adgroup.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup")
        AdGroupOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", mode = WebParam.Mode.OUT)
        Holder<AdGroupReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/AdGroup", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
