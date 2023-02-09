package com.cogent;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.entity.User;
import com.cogent.repository.UserRepository;

@SpringBootApplication
public class RestFulAuthorApplication {

	@Autowired
	private UserRepository repo;
	
	@PostConstruct
	public void registerUsers() {
		repo.save(new User(1, "John", "password", "johndoe@gmail.com"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestFulAuthorApplication.class, args);
	}

}
