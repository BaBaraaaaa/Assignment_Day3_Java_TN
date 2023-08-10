package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.vti")
@SpringBootApplication
public class TnvtiHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnvtiHelloWorldApplication.class, args);
		
	}

}
