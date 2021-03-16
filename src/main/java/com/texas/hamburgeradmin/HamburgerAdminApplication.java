package com.texas.hamburgeradmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* This is the Entry Point to our project location
 The annotation @SpringBoot is used to containerize the application*/

@SpringBootApplication
public class HamburgerAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamburgerAdminApplication.class, args);
	}

}
