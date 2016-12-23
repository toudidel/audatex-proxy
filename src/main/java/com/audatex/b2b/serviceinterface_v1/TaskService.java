package com.audatex.b2b.serviceinterface_v1;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

/**
 * The TaskService contains Task related operations. A Task is associated with a case in AudaNet and
 *     contains the complete case data. The TaskService allows to insert and retrieve task data in the AudaNet server
 *     
 *
 * This class was generated by Apache CXF 3.1.9
 * 2016-12-23T22:58:25.902+01:00
 * Generated source version: 3.1.9
 * 
 */
@WebServiceClient(name = "TaskService", 
                  wsdlLocation = "classpath:wsdl/TaskService_v1.wsdl",
                  targetNamespace = "http://serviceinterface_v1.b2b.audatex.com") 
public class TaskService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://serviceinterface_v1.b2b.audatex.com", "TaskService");
    public final static QName TaskServicePort = new QName("http://serviceinterface_v1.b2b.audatex.com", "TaskServicePort");
    static {
        URL url = TaskService.class.getClassLoader().getResource("wsdl/TaskService_v1.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(TaskService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/TaskService_v1.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public TaskService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public TaskService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TaskService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TaskService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns TaskServicePort
     */
    @WebEndpoint(name = "TaskServicePort")
    public TaskServicePort getTaskServicePort() {
        return super.getPort(TaskServicePort, TaskServicePort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TaskServicePort
     */
    @WebEndpoint(name = "TaskServicePort")
    public TaskServicePort getTaskServicePort(WebServiceFeature... features) {
        return super.getPort(TaskServicePort, TaskServicePort.class, features);
    }

}
