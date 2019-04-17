
package jp.yahooapis.im.v201903.adgroupad;

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
@WebServiceClient(name = "AdGroupAdService", targetNamespace = "http://im.yahooapis.jp/V201903/AdGroupAd", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201903/AdGroupAdService?wsdl")
public class AdGroupAdService
    extends Service
{

    private final static URL ADGROUPADSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPADSERVICE_EXCEPTION;
    private final static QName ADGROUPADSERVICE_QNAME = new QName("http://im.yahooapis.jp/V201903/AdGroupAd", "AdGroupAdService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201903/AdGroupAdService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPADSERVICE_WSDL_LOCATION = url;
        ADGROUPADSERVICE_EXCEPTION = e;
    }

    public AdGroupAdService() {
        super(__getWsdlLocation(), ADGROUPADSERVICE_QNAME);
    }

    public AdGroupAdService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPADSERVICE_QNAME, features);
    }

    public AdGroupAdService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPADSERVICE_QNAME);
    }

    public AdGroupAdService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPADSERVICE_QNAME, features);
    }

    public AdGroupAdService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupAdService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupAdServiceInterface
     */
    @WebEndpoint(name = "AdGroupAdService")
    public AdGroupAdServiceInterface getAdGroupAdService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/AdGroupAd", "AdGroupAdService"), AdGroupAdServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupAdServiceInterface
     */
    @WebEndpoint(name = "AdGroupAdService")
    public AdGroupAdServiceInterface getAdGroupAdService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/AdGroupAd", "AdGroupAdService"), AdGroupAdServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPADSERVICE_EXCEPTION!= null) {
            throw ADGROUPADSERVICE_EXCEPTION;
        }
        return ADGROUPADSERVICE_WSDL_LOCATION;
    }

}
