
package jp.yahooapis.im.V5.AccountAdProductService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AccountAdProductServiceInterface", targetNamespace = "http://im.yahooapis.jp/V5")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AccountAdProductServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.AccountAdProductService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.AccountAdProductService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V5")
        AccountAdProductSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<AccountAdProductPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
