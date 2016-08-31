
package jp.yahooapis.im.V5.AccountService;

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
@WebServiceClient(name = "AccountServiceService", targetNamespace = "http://im.yahooapis.jp/V5", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V5.3/AccountService?wsdl")
public class AccountServiceService
    extends Service
{

    private final static URL ACCOUNTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTSERVICESERVICE_EXCEPTION;
    private final static QName ACCOUNTSERVICESERVICE_QNAME = new QName("http://im.yahooapis.jp/V5", "AccountServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.im.yahooapis.jp/services/V5.3/AccountService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTSERVICESERVICE_WSDL_LOCATION = url;
        ACCOUNTSERVICESERVICE_EXCEPTION = e;
    }

    public AccountServiceService() {
        super(__getWsdlLocation(), ACCOUNTSERVICESERVICE_QNAME);
    }

    public AccountServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTSERVICESERVICE_QNAME, features);
    }

    public AccountServiceService(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTSERVICESERVICE_QNAME);
    }

    public AccountServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTSERVICESERVICE_QNAME, features);
    }

    public AccountServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AccountServiceInterface
     */
    @WebEndpoint(name = "AccountService")
    public AccountServiceInterface getAccountService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "AccountService"), AccountServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountServiceInterface
     */
    @WebEndpoint(name = "AccountService")
    public AccountServiceInterface getAccountService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V5", "AccountService"), AccountServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTSERVICESERVICE_EXCEPTION!= null) {
            throw ACCOUNTSERVICESERVICE_EXCEPTION;
        }
        return ACCOUNTSERVICESERVICE_WSDL_LOCATION;
    }

}
