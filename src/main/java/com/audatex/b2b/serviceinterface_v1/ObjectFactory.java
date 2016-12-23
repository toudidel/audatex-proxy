
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
    private final static QName _CreateTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "createTaskRequest");
    private final static QName _CreateTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "createTaskResponse");
    private final static QName _UpdateTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "updateTaskRequest");
    private final static QName _UpdateTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "updateTaskResponse");
    private final static QName _GetTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getTaskRequest");
    private final static QName _GetTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getTaskResponse");
    private final static QName _GetTaskListRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getTaskListRequest");
    private final static QName _GetTaskListResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "getTaskListResponse");
    private final static QName _FindTasksRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "findTasksRequest");
    private final static QName _FindTasksResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "findTasksResponse");
    private final static QName _ReassignTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reassignTaskRequest");
    private final static QName _ReassignTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reassignTaskResponse");
    private final static QName _ReopenTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reopenTaskRequest");
    private final static QName _ReopenTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reopenTaskResponse");
    private final static QName _ReopenCaseRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reopenCaseRequest");
    private final static QName _ReopenCaseResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "reopenCaseResponse");
    private final static QName _CloseTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "closeTaskRequest");
    private final static QName _CloseTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "closeTaskResponse");
    private final static QName _CloseCaseRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "closeCaseRequest");
    private final static QName _CloseCaseResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "closeCaseResponse");
    private final static QName _TransferTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "transferTaskRequest");
    private final static QName _TransferTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "transferTaskResponse");
    private final static QName _MergeTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "mergeTaskRequest");
    private final static QName _MergeTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "mergeTaskResponse");
    private final static QName _SendTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "sendTaskRequest");
    private final static QName _SendTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "sendTaskResponse");
    private final static QName _DeleteTaskRequest_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteTaskRequest");
    private final static QName _DeleteTaskResponse_QNAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "deleteTaskResponse");

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
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "createTaskRequest")
    public JAXBElement<B2BRequest> createCreateTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_CreateTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "createTaskResponse")
    public JAXBElement<B2BResponse> createCreateTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_CreateTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "updateTaskRequest")
    public JAXBElement<B2BRequest> createUpdateTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_UpdateTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "updateTaskResponse")
    public JAXBElement<B2BResponse> createUpdateTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_UpdateTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getTaskRequest")
    public JAXBElement<B2BRequest> createGetTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_GetTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getTaskResponse")
    public JAXBElement<B2BResponse> createGetTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_GetTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getTaskListRequest")
    public JAXBElement<B2BRequest> createGetTaskListRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_GetTaskListRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "getTaskListResponse")
    public JAXBElement<B2BResponse> createGetTaskListResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_GetTaskListResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "findTasksRequest")
    public JAXBElement<B2BRequest> createFindTasksRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_FindTasksRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "findTasksResponse")
    public JAXBElement<B2BResponse> createFindTasksResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_FindTasksResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reassignTaskRequest")
    public JAXBElement<B2BRequest> createReassignTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_ReassignTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reassignTaskResponse")
    public JAXBElement<B2BResponse> createReassignTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_ReassignTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reopenTaskRequest")
    public JAXBElement<B2BRequest> createReopenTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_ReopenTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reopenTaskResponse")
    public JAXBElement<B2BResponse> createReopenTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_ReopenTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reopenCaseRequest")
    public JAXBElement<B2BRequest> createReopenCaseRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_ReopenCaseRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "reopenCaseResponse")
    public JAXBElement<B2BResponse> createReopenCaseResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_ReopenCaseResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "closeTaskRequest")
    public JAXBElement<B2BRequest> createCloseTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_CloseTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "closeTaskResponse")
    public JAXBElement<B2BResponse> createCloseTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_CloseTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "closeCaseRequest")
    public JAXBElement<B2BRequest> createCloseCaseRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_CloseCaseRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "closeCaseResponse")
    public JAXBElement<B2BResponse> createCloseCaseResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_CloseCaseResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "transferTaskRequest")
    public JAXBElement<B2BRequest> createTransferTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_TransferTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "transferTaskResponse")
    public JAXBElement<B2BResponse> createTransferTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_TransferTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "mergeTaskRequest")
    public JAXBElement<B2BRequest> createMergeTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_MergeTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "mergeTaskResponse")
    public JAXBElement<B2BResponse> createMergeTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_MergeTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "sendTaskRequest")
    public JAXBElement<B2BRequest> createSendTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_SendTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "sendTaskResponse")
    public JAXBElement<B2BResponse> createSendTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_SendTaskResponse_QNAME, B2BResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteTaskRequest")
    public JAXBElement<B2BRequest> createDeleteTaskRequest(B2BRequest value) {
        return new JAXBElement<B2BRequest>(_DeleteTaskRequest_QNAME, B2BRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link B2BResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceinterface_v1.b2b.audatex.com", name = "deleteTaskResponse")
    public JAXBElement<B2BResponse> createDeleteTaskResponse(B2BResponse value) {
        return new JAXBElement<B2BResponse>(_DeleteTaskResponse_QNAME, B2BResponse.class, null, value);
    }

}
