
package jp.yahooapis.im.v201911.campaignmigration;

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
@WebService(name = "CampaignMigrationServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.campaignmigration.ObjectFactory.class
})
public interface CampaignMigrationServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getCampaignDownloadUrl", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetCampaignDownloadUrl")
    @ResponseWrapper(localName = "getCampaignDownloadUrlResponse", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetCampaignDownloadUrlResponse")
    public void getCampaignDownloadUrl(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration")
        CampaignDownloadSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
        Holder<CampaignDownloadUrlValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "getMigrationStatus", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetMigrationStatus")
    @ResponseWrapper(localName = "getMigrationStatusResponse", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetMigrationStatusResponse")
    public void getMigrationStatus(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration")
        MigrationStatusSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
        Holder<MigrationStatusPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "getUploadUrl", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetUploadUrl")
    @ResponseWrapper(localName = "getUploadUrlResponse", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", className = "jp.yahooapis.im.v201911.campaignmigration.GetUploadUrlResponse")
    public void getUploadUrl(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration")
        CampaignUploadSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
        Holder<UploadUrlValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/CampaignMigration", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
