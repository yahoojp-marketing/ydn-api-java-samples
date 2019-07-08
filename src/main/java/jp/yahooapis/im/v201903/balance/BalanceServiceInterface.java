
package jp.yahooapis.im.v201903.balance;

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
@WebService(name = "BalanceServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201903/Balance")
@XmlSeeAlso({
    jp.yahooapis.im.v201903.ObjectFactory.class,
    ObjectFactory.class
})
public interface BalanceServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201903/Balance", className = "jp.yahooapis.im.v201903.balance.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201903/Balance", className = "jp.yahooapis.im.v201903.balance.GetResponse")
    public void get(@WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201903/Balance") BalanceSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/Balance", mode = WebParam.Mode.OUT) Holder<BalancePage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/Balance", mode = WebParam.Mode.OUT) Holder<List<Error>> error)
        throws ApiException
    ;

}