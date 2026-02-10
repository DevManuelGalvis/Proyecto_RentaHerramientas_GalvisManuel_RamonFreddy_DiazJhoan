package com.campus.backendproject;

import com.campus.backendproject.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendprojectApplication {

	public static void main(String[] args){SpringApplication.run(BackendprojectApplication.class, args);}
}
