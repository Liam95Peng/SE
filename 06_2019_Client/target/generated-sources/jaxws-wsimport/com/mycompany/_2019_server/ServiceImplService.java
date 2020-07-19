
package com.mycompany._2019_server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceImplService", targetNamespace = "http://_2019_server.mycompany.com/", wsdlLocation = "http://localhost:8080/Service?wsdl")
public class ServiceImplService
    extends javax.xml.ws.Service
{

    private final static URL SERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICEIMPLSERVICE_EXCEPTION;
    private final static QName SERVICEIMPLSERVICE_QNAME = new QName("http://_2019_server.mycompany.com/", "ServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICEIMPLSERVICE_WSDL_LOCATION = url;
        SERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public ServiceImplService() {
        super(__getWsdlLocation(), SERVICEIMPLSERVICE_QNAME);
    }

    public ServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICEIMPLSERVICE_QNAME, features);
    }

    public ServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICEIMPLSERVICE_QNAME);
    }

    public ServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICEIMPLSERVICE_QNAME, features);
    }

    public ServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Service
     */
    @WebEndpoint(name = "ServiceImplPort")
    public com.mycompany._2019_server.Service getServiceImplPort() {
        return super.getPort(new QName("http://_2019_server.mycompany.com/", "ServiceImplPort"), Service.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Service
     */
    @WebEndpoint(name = "ServiceImplPort")
    public com.mycompany._2019_server.Service getServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://_2019_server.mycompany.com/", "ServiceImplPort"), Service.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw SERVICEIMPLSERVICE_EXCEPTION;
        }
        return SERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
