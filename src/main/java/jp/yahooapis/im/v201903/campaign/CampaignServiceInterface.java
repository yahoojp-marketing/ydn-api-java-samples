
package jp.yahooapis.im.v201903.campaign;

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
@WebService(name = "CampaignServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign")
@XmlSeeAlso({
    jp.yahooapis.im.v201903.ObjectFactory.class,
    ObjectFactory.class
})
public interface CampaignServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", className = "jp.yahooapis.im.v201903.campaign.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", className = "jp.yahooapis.im.v201903.campaign.GetResponse")
    public void get(@WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign") CampaignSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", mode = WebParam.Mode.OUT) Holder<CampaignPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", mode = WebParam.Mode.OUT) Holder<List<Error>> error)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", className = "jp.yahooapis.im.v201903.campaign.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", className = "jp.yahooapis.im.v201903.campaign.MutateResponse")
    public void mutate(@WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign") CampaignOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", mode = WebParam.Mode.OUT) Holder<CampaignReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/Campaign", mode = WebParam.Mode.OUT) Holder<List<Error>> error)
        throws ApiException
    ;

}
