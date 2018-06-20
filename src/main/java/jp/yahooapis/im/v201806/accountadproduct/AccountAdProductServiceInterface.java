
package jp.yahooapis.im.v201806.accountadproduct;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.im.v201806.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AccountAdProductServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct")
@XmlSeeAlso({
    jp.yahooapis.im.v201806.ObjectFactory.class,
    jp.yahooapis.im.v201806.accountadproduct.ObjectFactory.class
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
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct", className = "jp.yahooapis.im.v201806.accountadproduct.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct", className = "jp.yahooapis.im.v201806.accountadproduct.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct")
        AccountAdProductSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct", mode = WebParam.Mode.OUT)
        Holder<AccountAdProductPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201806/AccountAdProduct", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
