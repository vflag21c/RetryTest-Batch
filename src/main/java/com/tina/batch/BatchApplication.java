package com.tina.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BatchApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BatchApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}

}
