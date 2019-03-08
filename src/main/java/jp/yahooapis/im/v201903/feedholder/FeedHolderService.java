
package jp.yahooapis.im.v201903.feedholder;

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
@WebServiceClient(name = "FeedHolderService", targetNamespace = "http://im.yahooapis.jp/V201903/FeedHolder", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V201903/FeedHolderService?wsdl")
public class FeedHolderService
    extends Service
{

    private final static URL FEEDHOLDERSERVICE_WSDL_LOCATION;
    private final static WebServiceException FEEDHOLDERSERVICE_EXCEPTION;
    private final static QName FEEDHOLDERSERVICE_QNAME = new QName("http://im.yahooapis.jp/V201903/FeedHolder", "FeedHolderService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V201903/FeedHolderService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FEEDHOLDERSERVICE_WSDL_LOCATION = url;
        FEEDHOLDERSERVICE_EXCEPTION = e;
    }

    public FeedHolderService() {
        super(__getWsdlLocation(), FEEDHOLDERSERVICE_QNAME);
    }

    public FeedHolderService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FEEDHOLDERSERVICE_QNAME, features);
    }

    public FeedHolderService(URL wsdlLocation) {
        super(wsdlLocation, FEEDHOLDERSERVICE_QNAME);
    }

    public FeedHolderService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FEEDHOLDERSERVICE_QNAME, features);
    }

    public FeedHolderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FeedHolderService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FeedHolderServiceInterface
     */
    @WebEndpoint(name = "FeedHolderService")
    public FeedHolderServiceInterface getFeedHolderService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/FeedHolder", "FeedHolderService"), FeedHolderServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FeedHolderServiceInterface
     */
    @WebEndpoint(name = "FeedHolderService")
    public FeedHolderServiceInterface getFeedHolderService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V201903/FeedHolder", "FeedHolderService"), FeedHolderServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FEEDHOLDERSERVICE_EXCEPTION!= null) {
            throw FEEDHOLDERSERVICE_EXCEPTION;
        }
        return FEEDHOLDERSERVICE_WSDL_LOCATION;
    }

}
