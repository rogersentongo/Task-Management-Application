package com.rogersentongo.taskmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Task Management REST APIs",
				description="Task Controller REST APIs Documentation",
				version = "v1.0",
				contact=@Contact(
						name = "Roger Sentongo",
						email="rogersentongo@gmail.com"
				),
				license=@License(
						name ="Apache 2.0"
				)
		)
)
@SpringBootApplication
public class TaskManagementApplication {
	//configuring spring bean for modelmapper
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
