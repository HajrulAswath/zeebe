/**
* Eureka Server is an application that holds the information 
* about all client-service applications. 
* Every micro service will register into the Eureka server 
* and Eureka server knows all the client applications running on
* each port and IP address. 
* 
*
* @author  Hajrul Aswath B
* @version 1.0
* @since   2020-06-01
*/
package com.haj.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
