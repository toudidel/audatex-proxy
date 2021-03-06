package com.audatex.b2b.serviceinterface_v1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * The AttachmentService allows to upload and download attachment data. The attachments are always associated
 *    with a task.
 *    
 *
 * This class was generated by Apache CXF 3.1.9
 * 2017-01-05T21:07:32.539+01:00
 * Generated source version: 3.1.9
 * 
 */
@WebService(targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", name = "AttachmentServicePort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AttachmentServicePort {

    /**
     * Returns the attachments specified by their Id in the response payload. The attachments are returned as
     *     a AttachmentBinaryList structure. Each AttachmentBinary structure in this list has metadata (file name, creator,
     *     bytes count) and the actual attachment data as base64 encoded string.  
     *     
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *       
     *       * Parameter "taskId ": The Id of the task containing the attachments. Mandatory parameter.
     *       * Parameter "attachmentIds ": Comma separated list of Ids of the attachments to retrieve. The attachment Id is found at the following
     *      XPath in a task: /Task/AttachmentBinaryList/AttachmentBinary[i]/ItemId. If this parameter is not specified, all
     *      attachments in the tasks global attachment list are returned, provided the response size does not exceed a
     *      configurable limit. 
     *       
     *       * Parameter "processAsOrganization ": Specifies the organization on behalf of which this action is being done. Internally the service will 
     *       be performed on behalf of the provisioned contact person of the organization found. The format of this parameter 
     *       is: additional identifier (as defined in SAXIF MemberSearchEnumType) followed by a colon and the value to match. 
     *       Example: ExternalOrganisationId:AB123
     *     
     *       * Parameter "processAsUser ": Specifies the loginId of the actual user as which the operation will be performed. Use this parameter
     *         if there is a virtual user making the B2B call on behalf of an actual user.   
     */
    @WebMethod
    @WebResult(name = "getAttachmentsContentResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "getAttachmentsContentResponse")
    public B2BResponse getAttachmentsContent(
        @WebParam(partName = "getAttachmentsContentRequest", name = "getAttachmentsContentRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest getAttachmentsContentRequest
    );

    /**
     * Does nothing else than returning a fixed response. This can be used to test the connection to and the
     *    SOAP request handling of the AudaNet server. No user credentials need to be specified for this operation.
     *      
     */
    @WebMethod
    @WebResult(name = "pingResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "pingResponse")
    public B2BResponse ping(
        @WebParam(partName = "pingRequest", name = "pingRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest pingRequest
    );

    /**
     * Uploads attachments and adds them to an existing task. The attachments file name and content is specified
     *   in a SAXIF structure rooted at type AttachmentBinaryList in the request payload.
     *   The response payload contains an AttachmentBinaryList structure with the metadata (no content) of the attachments that
     *   were actually added to the task. This list can be empty if no attachments were added to the task.
     *   Attachments are compared using attachment file name, if uploaded attachment already exists in the task it will be ignored. For
     *   each ignored attachment an info message is added to response, specifying the file name of the attachment that was
     *   ignored.
     *   Note that some fields in the AttachmentBinary type are initialized by the server and read-only for a client. The only
     *   mandatory fields to define a valid attachment are FileName (with extension) and Source with the Attachment child tag
     *   that contains the actual Base64 encoded content.
     *   
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *       
     *       * Parameter "taskId ": The Id of the task to add the attachments to. The authenticated user must have write access to this
     *      task. Mandatory parameter.
     *       * Parameter "processAsOrganization ": Specifies the organization on behalf of which this action is being done. Internally the service will 
     *       be performed on behalf of the provisioned contact person of the organization found. The format of this parameter 
     *       is: additional identifier (as defined in SAXIF MemberSearchEnumType) followed by a colon and the value to match. 
     *       Example: ExternalOrganisationId:AB123
     *     
     *       * Parameter "processAsUser ": Specifies the loginId of the actual user as which the operation will be performed. Use this parameter
     *         if there is a virtual user making the B2B call on behalf of an actual user.   
     */
    @WebMethod
    @WebResult(name = "addAttachmentsToTaskResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "addAttachmentsToTaskResponse")
    public B2BResponse addAttachmentsToTask(
        @WebParam(partName = "addAttachmentsToTaskRequest", name = "addAttachmentsToTaskRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest addAttachmentsToTaskRequest
    );

    /**
     * A generic operation to executes an action. The action is specified as parameter. All operations in this
     *    service can also be invoked here, by specifying their operation name as action parameter (e.g.
     *    action="getTaskList").
     *    This serves two purposes: 1) new actions and customer specific actions can be added to this
     *    service without interface change. 2) a generic way to invoke operations.
     *     
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *          
     */
    @WebMethod
    @WebResult(name = "executeActionResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "executeActionResponse")
    public B2BResponse executeAction(
        @WebParam(partName = "executeActionRequest", name = "executeActionRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest executeActionRequest
    );

    /**
     * Remove the non global attachments specified by their IDs. The IDs are in request parameter attachmentIds. Only accessible to system admin users.
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *       
     *       * Parameter "taskId ": The Id of the task containing the attachments. Mandatory parameter.
     *       * Parameter "country ": The country of the task containing the attachments. Mandatory parameter.
     *       * Parameter "attachmentIds ": Comma separated list of Ids of the attachments to retrieve. The attachment Id is mandatory
     *     if you want to delete an attachment   
     */
    @WebMethod
    @WebResult(name = "deleteNonGlobalAttachmentsResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "deleteNonGlobalAttachmentsResponse")
    public B2BResponse deleteNonGlobalAttachments(
        @WebParam(partName = "deleteNonGlobalAttachmentsRequest", name = "deleteNonGlobalAttachmentsRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest deleteNonGlobalAttachmentsRequest
    );

    /**
     * Remove the attachments specified by their IDs. The IDs are in request parameter attachmentId.
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *       
     *       * Parameter "taskId ": The Id of the task containing the attachments. Mandatory parameter.
     *       * Parameter "attachmentIds ": Comma separated list of Ids of the attachments to retrieve. The attachment Id is mandatory
     *     if you want to delete an attachment
     *       * Parameter "processAsOrganization ": Specifies the organization on behalf of which this action is being done. Internally the service will 
     *       be performed on behalf of the provisioned contact person of the organization found. The format of this parameter 
     *       is: additional identifier (as defined in SAXIF MemberSearchEnumType) followed by a colon and the value to match. 
     *       Example: ExternalOrganisationId:AB123
     *     
     *       * Parameter "processAsUser ": Specifies the loginId of the actual user as which the operation will be performed. Use this parameter
     *         if there is a virtual user making the B2B call on behalf of an actual user.   
     */
    @WebMethod
    @WebResult(name = "deleteAttachmentsResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "deleteAttachmentsResponse")
    public B2BResponse deleteAttachments(
        @WebParam(partName = "deleteAttachmentsRequest", name = "deleteAttachmentsRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest deleteAttachmentsRequest
    );

    /**
     * Uploads attachments and adds them to an existing calculation in the task.
     *  The attachments file name and content is specified in a SAXIF structure rooted at type AttachmentBinaryList 
     *  in the request payload.The response payload contains an AttachmentBinaryList structure with the metadata (no content) 
     *  of the attachments that were actually added to the calculation.This list can be empty if no attachments were added.
     *  The attachments are compared using attachment file name, if uploaded attachment already exists in the specified 
     *  calculation in the task, it will be ignored. For each ignored attachment an info message is added to response, specifying 
     *  the file name of the attachment that was ignored. Note that some fields in the AttachmentBinary type are initialized by 
     *  the server and read-only for a client. The only mandatory fields to define a valid attachment are FileName (with extension)
     *  and Source with the Attachment child tag that contains the actual Base64 encoded content.
     *  
     *       * Parameter "loginId": The loginId ("username") of the AudaNet account, for authentication
     *       * Parameter "password": The password of the AudaNet account, for authentication
     *       
     *       * Parameter "taskId ": The Id of the task. The authenticated user must have write access to this
     *      task. Mandatory parameter.
     *       * Parameter "calculationId ": The Id of the calculation within the task for which the attachments will be added.
     *   	 Mandatory parameter.
     *       * Parameter "processAsOrganization ": Specifies the organization on behalf of which this action is being done. Internally the service will 
     *       be performed on behalf of the provisioned contact person of the organization found. The format of this parameter 
     *       is: additional identifier (as defined in SAXIF MemberSearchEnumType) followed by a colon and the value to match. 
     *       Example: ExternalOrganisationId:AB123
     *     
     *       * Parameter "processAsUser ": Specifies the loginId of the actual user as which the operation will be performed. Use this parameter
     *         if there is a virtual user making the B2B call on behalf of an actual user.   
     */
    @WebMethod
    @WebResult(name = "addAttachmentsToTaskCalculationResponse", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com", partName = "addAttachmentsToTaskCalculationResponse")
    public B2BResponse addAttachmentsToTaskCalculation(
        @WebParam(partName = "addAttachmentsToTaskCalculationRequest", name = "addAttachmentsToTaskCalculationRequest", targetNamespace = "http://serviceinterface_v1.b2b.audatex.com")
        B2BRequest addAttachmentsToTaskCalculationRequest
    );
}
