
package jp.yahooapis.im.V6.StatsService;

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
@WebServiceClient(name = "StatsService", targetNamespace = "http://im.yahooapis.jp/V6", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V6.1/StatsService?wsdl")
public class StatsService
    extends Service
{

    private final static URL STATSSERVICE_WSDL_LOCATION;
    private final static WebServiceException STATSSERVICE_EXCEPTION;
    private final static QName STATSSERVICE_QNAME = new QName("http://im.yahooapis.jp/V6", "StatsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V6.1/StatsService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STATSSERVICE_WSDL_LOCATION = url;
        STATSSERVICE_EXCEPTION = e;
    }

    public StatsService() {
        super(__getWsdlLocation(), STATSSERVICE_QNAME);
    }

    public StatsService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STATSSERVICE_QNAME, features);
    }

    public StatsService(URL wsdlLocation) {
        super(wsdlLocation, STATSSERVICE_QNAME);
    }

    public StatsService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STATSSERVICE_QNAME, features);
    }

    public StatsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StatsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StatsServiceInterface
     */
    @WebEndpoint(name = "StatsService")
    public StatsServiceInterface getStatsService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V6", "StatsService"), StatsServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StatsServiceInterface
     */
    @WebEndpoint(name = "StatsService")
    public StatsServiceInterface getStatsService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V6", "StatsService"), StatsServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STATSSERVICE_EXCEPTION!= null) {
            throw STATSSERVICE_EXCEPTION;
        }
        return STATSSERVICE_WSDL_LOCATION;
    }

}
