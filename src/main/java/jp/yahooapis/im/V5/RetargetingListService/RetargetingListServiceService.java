
package jp.yahooapis.im.V5.RetargetingListService;

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
@WebServiceClient(name = "RetargetingListServiceService", targetNamespace = "http://im.yahooapis.jp/V5", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V5.3/RetargetingListService?wsdl")
public class RetargetingListServiceService
    extends Service
{

    private final static URL RETARGETINGLISTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException RETARGETINGLISTSERVICESERVICE_EXCEPTION;
    private final static QName RETARGETINGLISTSERVICESERVICE_QNAME = new QName("http://im.yahooapis.jp/V5", "RetargetingListServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V5.3/RetargetingListService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RETARGETINGLISTSERVICESERVICE_WSDL_LOCATION = url;
        RETARGETINGLISTSERVICESERVICE_EXCEPTION = e;
    }

    public RetargetingListServiceService() {
        super(__getWsdlLocation(), RETARGETINGLISTSERVICESERVICE_QNAME);
    }

    public RetargetingListServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RETARGETINGLISTSERVICESERVICE_QNAME, features);
    }

    public RetargetingListServiceService(URL wsdlLocation) {
        super(wsdlLocation, RETARGETINGLISTSERVICESERVICE_QNAME);
    }

    public RetargetingListServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RETARGETINGLISTSERVICESERVICE_QNAME, features);
    }

    public RetargetingListServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetargetingListServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RetargetingListServiceInterface
     */
    @WebEndpoint(name = "RetargetingListService")
    public RetargetingListServiceInterface getRetargetingListService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "RetargetingListService"), RetargetingListServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RetargetingListServiceInterface
     */
    @WebEndpoint(name = "RetargetingListService")
    public RetargetingListServiceInterface getRetargetingListService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "RetargetingListService"), RetargetingListServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RETARGETINGLISTSERVICESERVICE_EXCEPTION!= null) {
            throw RETARGETINGLISTSERVICESERVICE_EXCEPTION;
        }
        return RETARGETINGLISTSERVICESERVICE_WSDL_LOCATION;
    }

}
