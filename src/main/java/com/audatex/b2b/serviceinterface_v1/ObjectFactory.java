
package com.audatex.b2b.serviceinterface_v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.audatex.b2b.serviceinterface_v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PingRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "pingRequest");
    private final static QName _PingResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "pingResponse");
    private final static QName _ExecuteActionRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "executeActionRequest");
    private final static QName _ExecuteActionResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "executeActionResponse");
    private final static QName _GetAttachmentsContentRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getAttachmentsContentRequest");
    private final static QName _GetAttachmentsContentResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getAttachmentsContentResponse");
    private final static QName _AddAttachmentsToTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "addAttachmentsToTaskRequest");
    private final static QName _AddAttachmentsToTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "addAttachmentsToTaskResponse");
    private final static QName _AddAttachmentsToTaskCalculationRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "addAttachmentsToTaskCalculationRequest");
    private final static QName _AddAttachmentsToTaskCalculationResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "addAttachmentsToTaskCalculationResponse");
    private final static QName _DeleteAttachmentsRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteAttachmentsRequest");
    private final static QName _DeleteAttachmentsResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteAttachmentsResponse");
    private final static QName _DeleteNonGlobalAttachmentsRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteNonGlobalAttachmentsRequest");
    private final static QName _DeleteNonGlobalAttachmentsResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteNonGlobalAttachmentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.audatex.b2b.serviceinterface_v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link B2BRequest }
     * 
     */
    public B2BRequest createB2BRequest() {
        return new B2BRequest();
    }

    /**
     * Create an instance of {@link B2BResponse }
     * 
     */
    public B2BResponse createB2BResponse() {
        return new B2BResponse();
    }

    /**
     * Create an instance of {@link B2BParameter }
     * 
     */
    public B2BParameter createB2BParameter() {
        return new B2BParameter();
    }

    /**
     * Create an instance of {@link B2BMessage }
     * 
     */
    public B2BMessage createB2BMessage() {
        return new B2BMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "pingRequest")
    public JAXBElement<B2BRequest> createPingRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_PingRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "pingResponse")
    public JAXBElement<B2BResponse> createPingResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_PingResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "executeActionRequest")
    public JAXBElement<B2BRequest> createExecuteActionRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_ExecuteActionRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "executeActionResponse")
    public JAXBElement<B2BResponse> createExecuteActionResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_ExecuteActionResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getAttachmentsContentRequest")
    public JAXBElement<B2BRequest> createGetAttachmentsContentRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_GetAttachmentsContentRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getAttachmentsContentResponse")
    public JAXBElement<B2BResponse> createGetAttachmentsContentResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_GetAttachmentsContentResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "addAttachmentsToTaskRequest")
    public JAXBElement<B2BRequest> createAddAttachmentsToTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_AddAttachmentsToTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "addAttachmentsToTaskResponse")
    public JAXBElement<B2BResponse> createAddAttachmentsToTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_AddAttachmentsToTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "addAttachmentsToTaskCalculationRequest")
    public JAXBElement<B2BRequest> createAddAttachmentsToTaskCalculationRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_AddAttachmentsToTaskCalculationRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "addAttachmentsToTaskCalculationResponse")
    public JAXBElement<B2BResponse> createAddAttachmentsToTaskCalculationResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_AddAttachmentsToTaskCalculationResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteAttachmentsRequest")
    public JAXBElement<B2BRequest> createDeleteAttachmentsRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_DeleteAttachmentsRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteAttachmentsResponse")
    public JAXBElement<B2BResponse> createDeleteAttachmentsResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_DeleteAttachmentsResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteNonGlobalAttachmentsRequest")
    public JAXBElement<B2BRequest> createDeleteNonGlobalAttachmentsRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_DeleteNonGlobalAttachmentsRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteNonGlobalAttachmentsResponse")
    public JAXBElement<B2BResponse> createDeleteNonGlobalAttachmentsResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_DeleteNonGlobalAttachmentsResponse_QNAME, B2BResponse.class, null, value);
    }

}
