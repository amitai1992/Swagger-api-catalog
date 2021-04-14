package com.springboot.SwaggerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.springboot.SwaggerAPI.Repository")
@EntityScan("com.springboot.SwaggerAPI.Model")
@SpringBootApplication
public class SwaggerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiApplication.class, args);
	}

}
