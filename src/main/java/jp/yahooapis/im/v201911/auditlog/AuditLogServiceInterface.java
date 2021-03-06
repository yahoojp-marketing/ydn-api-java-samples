
package jp.yahooapis.im.v201911.auditlog;

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
@WebService(name = "AuditLogServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.auditlog.ObjectFactory.class
})
public interface AuditLogServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getDownload", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", className = "jp.yahooapis.im.v201911.auditlog.GetDownload")
    @ResponseWrapper(localName = "getDownloadResponse", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", className = "jp.yahooapis.im.v201911.auditlog.GetDownloadResponse")
    public void getDownload(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog")
        AuditLogDownloadSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", mode = WebParam.Mode.OUT)
        Holder<AuditLogDownloadReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "getDownloadStatus", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", className = "jp.yahooapis.im.v201911.auditlog.GetDownloadStatus")
    @ResponseWrapper(localName = "getDownloadStatusResponse", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", className = "jp.yahooapis.im.v201911.auditlog.GetDownloadStatusResponse")
    public void getDownloadStatus(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog")
        AuditLogDownloadStatusSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", mode = WebParam.Mode.OUT)
        Holder<AuditLogDownloadStatusPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/AuditLog", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
