package com.kishore.dynamicworkflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kishore.dynamicworkflow.model.User;
import com.kishore.dynamicworkflow.repository.UserRepository;

@SpringBootApplication
public class DynamicworkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicworkflowApplication.class, args);
	}
	
	@Bean
	CommandLineRunner insertStartupData(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("User 1"));
			userRepository.save(new User("User 2"));
			userRepository.save(new User("User 3"));
			userRepository.save(new User("User 4"));
			userRepository.save(new User("User 5"));

			
		};
		
	} 
	
}
