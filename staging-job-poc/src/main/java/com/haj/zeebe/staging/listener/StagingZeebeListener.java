/**
* Zeebe Worker listener class, this will be invoked 
* when the bpmn file is executed.
*
* @author  Hajrul Aswath B
* @version 1.0
* @since   2020-06-01
*/
package com.haj.zeebe.staging.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.zeebe.client.api.response.ActivatedJob;
import io.zeebe.client.api.worker.JobClient;
import io.zeebe.spring.client.ZeebeClientLifecycle;
import io.zeebe.spring.client.annotation.ZeebeWorker;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StagingZeebeListener {
	
	@Autowired
	  private ZeebeClientLifecycle client;
	
	@ZeebeWorker(type = "Staging")
	public void handleJobTypeTaskA(final JobClient jobClient, final ActivatedJob activatedJob) throws IOException {
		log.info("activatedJob :: {}", activatedJob);
		final long key = activatedJob.getKey();
		log.info("jobtypeselection - key :: {}", key);
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		client.newCompleteCommand(key).variables(result).send();
	}

}
