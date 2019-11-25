
package jp.yahooapis.im.v201911.media;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MediaService", targetNamespace = "http://im.yahooapis.jp/V201911/Media", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201911/MediaService?wsdl")
public class MediaService
    extends Service
{

    private final static URL MEDIASERVICE_WSDL_LOCATION;
    private final static WebServiceException MEDIASERVICE_EXCEPTION;
    private final static QName MEDIASERVICE_QNAME = new QName("http://im.yahooapis.jp/V201911/Media", "MediaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201911/MediaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MEDIASERVICE_WSDL_LOCATION = url;
        MEDIASERVICE_EXCEPTION = e;
    }

    public MediaService() {
        super(__getWsdlLocation(), MEDIASERVICE_QNAME);
    }

    public MediaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEDIASERVICE_QNAME, features);
    }

    public MediaService(URL wsdlLocation) {
        super(wsdlLocation, MEDIASERVICE_QNAME);
    }

    public MediaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEDIASERVICE_QNAME, features);
    }

    public MediaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MediaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MediaServiceInterface
     */
    @WebEndpoint(name = "MediaService")
    public MediaServiceInterface getMediaService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201911/Media", "MediaService"), MediaServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MediaServiceInterface
     */
    @WebEndpoint(name = "MediaService")
    public MediaServiceInterface getMediaService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201911/Media", "MediaService"), MediaServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEDIASERVICE_EXCEPTION!= null) {
            throw MEDIASERVICE_EXCEPTION;
        }
        return MEDIASERVICE_WSDL_LOCATION;
    }

}