
package jp.yahooapis.im.V5.BulkService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "BulkServiceService", targetNamespace = "http://im.yahooapis.jp/V5", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V5.0/BulkService?wsdl")
public class BulkServiceService
    extends Service
{

    private final static URL BULKSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(jp.yahooapis.im.V5.BulkService.BulkServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = jp.yahooapis.im.V5.BulkService.BulkServiceService.class.getResource(".");
            url = new URL(baseUrl, "https://sandbox.im.yahooapis.jp/services/V5.0/BulkService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://sandbox.im.yahooapis.jp/services/V5.0/BulkService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        BULKSERVICESERVICE_WSDL_LOCATION = url;
    }

    public BulkServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BulkServiceService() {
        super(BULKSERVICESERVICE_WSDL_LOCATION, new QName("http://im.yahooapis.jp/V5", "BulkServiceService"));
    }

    /**
     * 
     * @return
     *     returns BulkServiceInterface
     */
    @WebEndpoint(name = "BulkService")
    public BulkServiceInterface getBulkService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "BulkService"), BulkServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BulkServiceInterface
     */
    @WebEndpoint(name = "BulkService")
    public BulkServiceInterface getBulkService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "BulkService"), BulkServiceInterface.class, features);
    }

}
