
package jp.yahooapis.im.v201911.feeddata;

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
@WebServiceClient(name = "FeedDataService", targetNamespace = "http://im.yahooapis.jp/V201911/FeedData", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201911/FeedDataService?wsdl")
public class FeedDataService
    extends Service
{

    private final static URL FEEDDATASERVICE_WSDL_LOCATION;
    private final static WebServiceException FEEDDATASERVICE_EXCEPTION;
    private final static QName FEEDDATASERVICE_QNAME = new QName("http://im.yahooapis.jp/V201911/FeedData", "FeedDataService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201911/FeedDataService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FEEDDATASERVICE_WSDL_LOCATION = url;
        FEEDDATASERVICE_EXCEPTION = e;
    }

    public FeedDataService() {
        super(__getWsdlLocation(), FEEDDATASERVICE_QNAME);
    }

    public FeedDataService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FEEDDATASERVICE_QNAME, features);
    }

    public FeedDataService(URL wsdlLocation) {
        super(wsdlLocation, FEEDDATASERVICE_QNAME);
    }

    public FeedDataService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FEEDDATASERVICE_QNAME, features);
    }

    public FeedDataService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FeedDataService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FeedDataServiceInterface
     */
    @WebEndpoint(name = "FeedDataService")
    public FeedDataServiceInterface getFeedDataService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201911/FeedData", "FeedDataService"), FeedDataServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FeedDataServiceInterface
     */
    @WebEndpoint(name = "FeedDataService")
    public FeedDataServiceInterface getFeedDataService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201911/FeedData", "FeedDataService"), FeedDataServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FEEDDATASERVICE_EXCEPTION!= null) {
            throw FEEDDATASERVICE_EXCEPTION;
        }
        return FEEDDATASERVICE_WSDL_LOCATION;
    }

}
