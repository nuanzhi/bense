package com.lsege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BenseMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenseMasterApplication.class, args);
	}
}
