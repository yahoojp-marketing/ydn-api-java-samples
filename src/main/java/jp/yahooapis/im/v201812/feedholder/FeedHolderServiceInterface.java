
package jp.yahooapis.im.v201812.feedholder;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.im.v201812.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FeedHolderServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder")
@XmlSeeAlso({
    jp.yahooapis.im.v201812.ObjectFactory.class,
    jp.yahooapis.im.v201812.feedholder.ObjectFactory.class
})
public interface FeedHolderServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", className = "jp.yahooapis.im.v201812.feedholder.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", className = "jp.yahooapis.im.v201812.feedholder.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder")
        FeedHolderSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", mode = WebParam.Mode.OUT)
        Holder<FeedHolderPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", className = "jp.yahooapis.im.v201812.feedholder.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", className = "jp.yahooapis.im.v201812.feedholder.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder")
        FeedHolderOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", mode = WebParam.Mode.OUT)
        Holder<FeedHolderReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201812/FeedHolder", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
