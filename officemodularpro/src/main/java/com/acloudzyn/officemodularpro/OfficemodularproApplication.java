package com.acloudzyn.officemodularpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
public class OfficemodularproApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OfficemodularproApplication.class, args);
		
	}

	 
}
