/**
* Zeebe Worker listener class, this will be invoked 
* when the bpmn file is executed.
*
* @author  Hajrul Aswath B
* @version 1.0
* @since   2020-06-01
*/
package com.haj.zeebe.validation.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.zeebe.client.api.response.ActivatedJob;
import io.zeebe.client.api.worker.JobClient;
import io.zeebe.spring.client.ZeebeClientLifecycle;
import io.zeebe.spring.client.annotation.ZeebeWorker;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ValidationZeebeListener {
	
	@Autowired
	  private ZeebeClientLifecycle client;
	
	  @ZeebeWorker(type = "Validation")
		public void handleJobTypeTaskC(final JobClient jobClient, final ActivatedJob activatedJob) throws IOException {
			log.info("activatedJob :: {}", activatedJob);
			final long key = activatedJob.getKey();
			log.info("jobtypeselection - key :: {}", key);
			client.newCompleteCommand(key).send();
		}

}
