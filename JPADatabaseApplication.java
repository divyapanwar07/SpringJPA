package com.example.spring.database.springdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.database.springdatabase.jpa.PersonJpaRepository;

@SpringBootApplication
public class JPADatabaseApplication implements CommandLineRunner {
	
	private Logger loggerObj = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPADatabaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		loggerObj.info("User 10001 : {}", repository.findById(10001));
		
		/*
		 * loggerObj.info("All Users : {}", daoObj.findAll());
		 * loggerObj.info("Deleting 10003 : No.of rows effected : {}",daoObj.deleteById(
		 * 10003)); loggerObj.info("Inserting user : {}", daoObj.insertPersonData(new
		 * Person(10004, "Varsha", "Bhopal", new Date())));
		 * loggerObj.info("Updatong user : {}", daoObj.updatePersonData(new
		 * Person(10002, "Mandeep", "Haryana", new Date())));
		 */
		
	}

}
