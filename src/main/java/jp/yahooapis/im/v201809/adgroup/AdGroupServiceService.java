
package jp.yahooapis.im.v201809.adgroup;

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
@WebServiceClient(name = "AdGroupServiceService", targetNamespace = "http://im.yahooapis.jp/V201809/AdGroup", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201809/AdGroupService?wsdl")
public class AdGroupServiceService
    extends Service
{

    private final static URL ADGROUPSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPSERVICESERVICE_EXCEPTION;
    private final static QName ADGROUPSERVICESERVICE_QNAME = new QName("http://im.yahooapis.jp/V201809/AdGroup", "AdGroupServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201809/AdGroupService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPSERVICESERVICE_WSDL_LOCATION = url;
        ADGROUPSERVICESERVICE_EXCEPTION = e;
    }

    public AdGroupServiceService() {
        super(__getWsdlLocation(), ADGROUPSERVICESERVICE_QNAME);
    }

    public AdGroupServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPSERVICESERVICE_QNAME, features);
    }

    public AdGroupServiceService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPSERVICESERVICE_QNAME);
    }

    public AdGroupServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPSERVICESERVICE_QNAME, features);
    }

    public AdGroupServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupServiceInterface
     */
    @WebEndpoint(name = "AdGroupService")
    public AdGroupServiceInterface getAdGroupService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201809/AdGroup", "AdGroupService"), AdGroupServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupServiceInterface
     */
    @WebEndpoint(name = "AdGroupService")
    public AdGroupServiceInterface getAdGroupService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201809/AdGroup", "AdGroupService"), AdGroupServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPSERVICESERVICE_EXCEPTION!= null) {
            throw ADGROUPSERVICESERVICE_EXCEPTION;
        }
        return ADGROUPSERVICESERVICE_WSDL_LOCATION;
    }

}