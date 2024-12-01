package com.example.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizappApplication {

	
	// Quiz Service - > CreateQuiz getScore get 
	// this both will communicate with HTTP
	//Question -> add remove update read 
	
	// we can scale of the each services based on requirement or demand eg quiz instances services  scale instances 
	// when client http comes does nt know which services to go this is where API Gateway or load balancer
	// wht if we have 10 services to find or check to know we need service registry 
	// wht if service is not a service goes down failed fast we need have another alternatives 
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}

}
