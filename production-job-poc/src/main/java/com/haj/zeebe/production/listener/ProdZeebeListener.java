/**
* Zeebe Worker listener class, this will be invoked 
* when the bpmn file is executed.
*
* @author  Hajrul Aswath B
* @version 1.0
* @since   2020-06-01
*/
package com.haj.zeebe.production.listener;

import java.io.IOException;
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
public class ProdZeebeListener {
	
	@Autowired
	  private ZeebeClientLifecycle client;
	
	
	@ZeebeWorker(type = "Production")
	public void handleJobTypeTaskB(final JobClient jobClient, final ActivatedJob activatedJob) throws IOException {
		log.info("activatedJob :: {}", activatedJob);
		final long key = activatedJob.getKey();
		Map<String, Object> variablesAsMap = activatedJob.getVariablesAsMap();
		String result = (String)variablesAsMap.get("result");
		variablesAsMap.put("result", "failure");
		log.info("jobtypeselection - result :: {}", result);
		client.newCompleteCommand(key).variables(variablesAsMap).send();
	}

}
