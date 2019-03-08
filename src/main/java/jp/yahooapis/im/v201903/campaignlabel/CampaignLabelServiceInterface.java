
package jp.yahooapis.im.v201903.campaignlabel;

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
@WebService(name = "CampaignLabelServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel")
@XmlSeeAlso({
    jp.yahooapis.im.v201903.ObjectFactory.class,
    jp.yahooapis.im.v201903.campaignlabel.ObjectFactory.class
})
public interface CampaignLabelServiceInterface {


    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel", className = "jp.yahooapis.im.v201903.campaignlabel.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel", className = "jp.yahooapis.im.v201903.campaignlabel.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel")
        CampaignLabelOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel", mode = WebParam.Mode.OUT)
        Holder<CampaignLabelReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201903/CampaignLabel", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
