package com.app.challenge_2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}

	
	//Its important to annotate the class with @Configuration, 
	//then only @Bean gets recognised by Spring boot Application.
}
