
package jp.yahooapis.im.v201911.feedftprequest;

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
@WebService(name = "FeedFtpRequestServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.feedftprequest.ObjectFactory.class
})
public interface FeedFtpRequestServiceInterface {


    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest", className = "jp.yahooapis.im.v201911.feedftprequest.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest", className = "jp.yahooapis.im.v201911.feedftprequest.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest")
        FeedFtpRequestOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest", mode = WebParam.Mode.OUT)
        Holder<FeedFtpRequestReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/FeedFtpRequest", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
