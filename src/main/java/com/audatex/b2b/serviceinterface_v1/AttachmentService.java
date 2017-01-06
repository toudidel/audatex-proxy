package com.audatex.b2b.serviceinterface_v1;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

/**
 * The AttachmentService allows to upload and download attachment data. The attachments are always associated
 *    with a task.
 *    
 *
 * This class was generated by Apache CXF 3.1.9
 * 2017-01-05T21:07:32.547+01:00
 * Generated source version: 3.1.9
 * 
 */
@WebServiceClient(name = "AttachmentService", 
                  wsdlLocation = "classpath:wsdl/AttachmentService_v1.wsdl",
                  targetNamespace = "http://serviceinterface_v1.b2b.audatex.com") 
public class AttachmentService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://serviceinterface_v1.b2b.audatex.com", "AttachmentService");
    public final static QName AttachmentServicePort = new QName("http://serviceinterface_v1.b2b.audatex.com", "AttachmentServicePort");
    static {
        URL url = AttachmentService.class.getClassLoader().getResource("wsdl/AttachmentService_v1.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(AttachmentService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/AttachmentService_v1.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public AttachmentService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AttachmentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AttachmentService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public AttachmentService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public AttachmentService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public AttachmentService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns AttachmentServicePort
     */
    @WebEndpoint(name = "AttachmentServicePort")
    public AttachmentServicePort getAttachmentServicePort() {
        return super.getPort(AttachmentServicePort, AttachmentServicePort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AttachmentServicePort
     */
    @WebEndpoint(name = "AttachmentServicePort")
    public AttachmentServicePort getAttachmentServicePort(WebServiceFeature... features) {
        return super.getPort(AttachmentServicePort, AttachmentServicePort.class, features);
    }

}
