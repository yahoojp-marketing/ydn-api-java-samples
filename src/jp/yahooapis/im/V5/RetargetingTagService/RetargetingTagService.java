
package jp.yahooapis.im.V5.RetargetingTagService;

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
@WebServiceClient(name = "RetargetingTagService", targetNamespace = "http://im.yahooapis.jp/V5", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V5.0/RetargetingTagService?wsdl")
public class RetargetingTagService
    extends Service
{

    private final static URL RETARGETINGTAGSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(jp.yahooapis.im.V5.RetargetingTagService.RetargetingTagService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = jp.yahooapis.im.V5.RetargetingTagService.RetargetingTagService.class.getResource(".");
            url = new URL(baseUrl, "https://sandbox.im.yahooapis.jp/services/V5.0/RetargetingTagService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://sandbox.im.yahooapis.jp/services/V5.0/RetargetingTagService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        RETARGETINGTAGSERVICE_WSDL_LOCATION = url;
    }

    public RetargetingTagService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetargetingTagService() {
        super(RETARGETINGTAGSERVICE_WSDL_LOCATION, new QName("http://im.yahooapis.jp/V5", "RetargetingTagService"));
    }

    /**
     * 
     * @return
     *     returns RetargetingTagServiceInterface
     */
    @WebEndpoint(name = "RetargetingTagService")
    public RetargetingTagServiceInterface getRetargetingTagService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "RetargetingTagService"), RetargetingTagServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RetargetingTagServiceInterface
     */
    @WebEndpoint(name = "RetargetingTagService")
    public RetargetingTagServiceInterface getRetargetingTagService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "RetargetingTagService"), RetargetingTagServiceInterface.class, features);
    }

}
