package com.haj.zeebe.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.zeebe.spring.client.EnableZeebeClient;
import io.zeebe.spring.client.annotation.ZeebeDeployment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@EnableJpaRepositories
@SpringBootApplication
@EnableZeebeClient
@ZeebeDeployment(classPathResources = "demoProcess.bpmn")
public class ZeebeValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeebeValidationApplication.class, args);
	}

}
