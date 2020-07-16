package io.zeebe.spring.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.spring.client.ZeebeClientLifecycle;

@RestController
public class ZeebeController {
	
	private static final Logger log = LoggerFactory.getLogger(ZeebeController.class);
	
	  @Autowired
	  private ZeebeClientLifecycle client;
	  
	  @RequestMapping("/startprocessess")
	  public void startProcesses() {
		    if (!client.isRunning()) {
		      return;
		    }

		    final WorkflowInstanceEvent event =
		      client
		        .newCreateInstanceCommand()
		        .bpmnProcessId("demoProcess")
		        .latestVersion()      
		        .send()
		        .join();

		   log.info("started instance for workflowKey='{}', bpmnProcessId='{}', version='{}' with workflowInstanceKey='{}'",
		      event.getWorkflowKey(), event.getBpmnProcessId(), event.getVersion(), event.getWorkflowInstanceKey());
		  }

}
