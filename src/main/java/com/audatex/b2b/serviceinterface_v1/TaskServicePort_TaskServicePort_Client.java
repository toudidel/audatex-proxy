
package com.audatex.b2b.serviceinterface_v1;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2016-12-23T22:58:25.826+01:00
 * Generated source version: 3.1.9
 * 
 */
public final class TaskServicePort_TaskServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://serviceinterface_v1.b2b.audatex.com", "TaskService");

    private TaskServicePort_TaskServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TaskService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        TaskService ss = new TaskService(wsdlURL, SERVICE_NAME);
        TaskServicePort port = ss.getTaskServicePort();  
        
        {
        System.out.println("Invoking closeTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _closeTask_closeTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _closeTask__return = port.closeTask(_closeTask_closeTaskRequest);
        System.out.println("closeTask.result=" + _closeTask__return);


        }
        {
        System.out.println("Invoking mergeTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _mergeTask_mergeTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _mergeTask__return = port.mergeTask(_mergeTask_mergeTaskRequest);
        System.out.println("mergeTask.result=" + _mergeTask__return);


        }
        {
        System.out.println("Invoking ping...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _ping_pingRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _ping__return = port.ping(_ping_pingRequest);
        System.out.println("ping.result=" + _ping__return);


        }
        {
        System.out.println("Invoking findTasks...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _findTasks_findTasksRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _findTasks__return = port.findTasks(_findTasks_findTasksRequest);
        System.out.println("findTasks.result=" + _findTasks__return);


        }
        {
        System.out.println("Invoking transferTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _transferTask_transferTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _transferTask__return = port.transferTask(_transferTask_transferTaskRequest);
        System.out.println("transferTask.result=" + _transferTask__return);


        }
        {
        System.out.println("Invoking updateTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _updateTask_updateTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _updateTask__return = port.updateTask(_updateTask_updateTaskRequest);
        System.out.println("updateTask.result=" + _updateTask__return);


        }
        {
        System.out.println("Invoking reassignTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _reassignTask_reassignTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _reassignTask__return = port.reassignTask(_reassignTask_reassignTaskRequest);
        System.out.println("reassignTask.result=" + _reassignTask__return);


        }
        {
        System.out.println("Invoking sendTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _sendTask_sendTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _sendTask__return = port.sendTask(_sendTask_sendTaskRequest);
        System.out.println("sendTask.result=" + _sendTask__return);


        }
        {
        System.out.println("Invoking reopenCase...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _reopenCase_reopenCaseRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _reopenCase__return = port.reopenCase(_reopenCase_reopenCaseRequest);
        System.out.println("reopenCase.result=" + _reopenCase__return);


        }
        {
        System.out.println("Invoking executeAction...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _executeAction_executeActionRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _executeAction__return = port.executeAction(_executeAction_executeActionRequest);
        System.out.println("executeAction.result=" + _executeAction__return);


        }
        {
        System.out.println("Invoking getTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _getTask_getTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _getTask__return = port.getTask(_getTask_getTaskRequest);
        System.out.println("getTask.result=" + _getTask__return);


        }
        {
        System.out.println("Invoking closeCase...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _closeCase_closeCaseRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _closeCase__return = port.closeCase(_closeCase_closeCaseRequest);
        System.out.println("closeCase.result=" + _closeCase__return);


        }
        {
        System.out.println("Invoking createTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _createTask_createTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _createTask__return = port.createTask(_createTask_createTaskRequest);
        System.out.println("createTask.result=" + _createTask__return);


        }
        {
        System.out.println("Invoking getTaskList...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _getTaskList_getTaskListRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _getTaskList__return = port.getTaskList(_getTaskList_getTaskListRequest);
        System.out.println("getTaskList.result=" + _getTaskList__return);


        }
        {
        System.out.println("Invoking reopenTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _reopenTask_reopenTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _reopenTask__return = port.reopenTask(_reopenTask_reopenTaskRequest);
        System.out.println("reopenTask.result=" + _reopenTask__return);


        }
        {
        System.out.println("Invoking deleteTask...");
        com.audatex.b2b.serviceinterface_v1.B2BRequest _deleteTask_deleteTaskRequest = null;
        com.audatex.b2b.serviceinterface_v1.B2BResponse _deleteTask__return = port.deleteTask(_deleteTask_deleteTaskRequest);
        System.out.println("deleteTask.result=" + _deleteTask__return);


        }

        System.exit(0);
    }

}
