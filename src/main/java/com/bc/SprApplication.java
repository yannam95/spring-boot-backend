package com.bc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*@ComponentScan(basePackages="com.bc.controllers")
@ComponentScan(basePackages="com.bc.entities")
@ComponentScan(basePackages="com.bc.repositories")*/

@SpringBootApplication
public class SprApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprApplication.class, args);
	}
}
