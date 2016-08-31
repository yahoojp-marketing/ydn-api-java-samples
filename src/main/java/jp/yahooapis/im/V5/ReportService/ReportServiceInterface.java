
package jp.yahooapis.im.V5.ReportService;

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
@WebService(name = "ReportServiceInterface", targetNamespace = "http://im.yahooapis.jp/V5")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReportServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V5")
        ReportSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<ReportPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "getDownloadUrl", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.GetDownloadUrl")
    @ResponseWrapper(localName = "getDownloadUrlResponse", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.GetDownloadUrlResponse")
    public void getDownloadUrl(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V5")
        ReportDownloadUrlSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<ReportDownloadUrlPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "getClosedDate", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.GetClosedDate")
    @ResponseWrapper(localName = "getClosedDateResponse", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.GetClosedDateResponse")
    public void getClosedDate(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V5")
        ReportClosedDateSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<ReportClosedDateValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V5", className = "jp.yahooapis.im.V5.ReportService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V5")
        ReportJobOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<ReportReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
