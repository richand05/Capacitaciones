package com.richrb97.users1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class Users1Application {

	public static void main(String[] args) {
		SpringApplication.run(Users1Application.class, args);
	}

}
