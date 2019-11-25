
package jp.yahooapis.im.v201911.video;

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
@WebService(name = "VideoServiceInterface", targetNamespace = "http://im.yahooapis.jp/V201911/Video")
@XmlSeeAlso({
    jp.yahooapis.im.v201911.ObjectFactory.class,
    jp.yahooapis.im.v201911.video.ObjectFactory.class
})
public interface VideoServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V201911/Video")
        VideoSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
        Holder<VideoPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V201911/Video")
        VideoOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
        Holder<VideoReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param accountId
     * @param rval
     * @param uploadVideo
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getUploadUrl", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.GetUploadUrl")
    @ResponseWrapper(localName = "getUploadUrlResponse", targetNamespace = "http://im.yahooapis.jp/V201911/Video", className = "jp.yahooapis.im.v201911.video.GetUploadUrlResponse")
    public void getUploadUrl(
        @WebParam(name = "accountId", targetNamespace = "http://im.yahooapis.jp/V201911/Video")
        long accountId,
        @WebParam(name = "uploadVideo", targetNamespace = "http://im.yahooapis.jp/V201911/Video")
        List<UploadVideo> uploadVideo,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
        Holder<UploadUrlPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V201911/Video", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
