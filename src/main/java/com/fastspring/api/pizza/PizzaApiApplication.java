package com.fastspring.api.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PizzaApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(PizzaApiApplication.class, args);
	}



}

