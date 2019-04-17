
package jp.yahooapis.im.v201903.placementurlidea;

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
@WebServiceClient(name = "PlacementUrlIdeaService", targetNamespace = "http://im.yahooapis.jp/V201903/PlacementUrlIdea", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201903/PlacementUrlIdeaService?wsdl")
public class PlacementUrlIdeaService
    extends Service
{

    private final static URL PLACEMENTURLIDEASERVICE_WSDL_LOCATION;
    private final static WebServiceException PLACEMENTURLIDEASERVICE_EXCEPTION;
    private final static QName PLACEMENTURLIDEASERVICE_QNAME = new QName("http://im.yahooapis.jp/V201903/PlacementUrlIdea", "PlacementUrlIdeaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201903/PlacementUrlIdeaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PLACEMENTURLIDEASERVICE_WSDL_LOCATION = url;
        PLACEMENTURLIDEASERVICE_EXCEPTION = e;
    }

    public PlacementUrlIdeaService() {
        super(__getWsdlLocation(), PLACEMENTURLIDEASERVICE_QNAME);
    }

    public PlacementUrlIdeaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PLACEMENTURLIDEASERVICE_QNAME, features);
    }

    public PlacementUrlIdeaService(URL wsdlLocation) {
        super(wsdlLocation, PLACEMENTURLIDEASERVICE_QNAME);
    }

    public PlacementUrlIdeaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PLACEMENTURLIDEASERVICE_QNAME, features);
    }

    public PlacementUrlIdeaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PlacementUrlIdeaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PlacementUrlIdeaServiceInterface
     */
    @WebEndpoint(name = "PlacementUrlIdeaService")
    public PlacementUrlIdeaServiceInterface getPlacementUrlIdeaService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/PlacementUrlIdea", "PlacementUrlIdeaService"), PlacementUrlIdeaServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PlacementUrlIdeaServiceInterface
     */
    @WebEndpoint(name = "PlacementUrlIdeaService")
    public PlacementUrlIdeaServiceInterface getPlacementUrlIdeaService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/PlacementUrlIdea", "PlacementUrlIdeaService"), PlacementUrlIdeaServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PLACEMENTURLIDEASERVICE_EXCEPTION!= null) {
            throw PLACEMENTURLIDEASERVICE_EXCEPTION;
        }
        return PLACEMENTURLIDEASERVICE_WSDL_LOCATION;
    }

}
