package com.example.spring.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.database.springdatabase.entity.Person;
import com.example.spring.database.springdatabase.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDatabaseApplication implements CommandLineRunner {
	
	private Logger loggerObj = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	PersonJdbcDao daoObj;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDatabaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		loggerObj.info("All Users : {}", daoObj.findAll());
		loggerObj.info("User 10001 : {}", daoObj.findById(10001));
		loggerObj.info("Deleting 10003 : No.of rows effected : {}",daoObj.deleteById(10003));
		loggerObj.info("Inserting user : {}", daoObj.insertPersonData(new Person(10004, "Varsha", "Bhopal", new Date())));
		loggerObj.info("Updatong user : {}", daoObj.updatePersonData(new Person(10002, "Mandeep", "Haryana", new Date())));
		
	}

}
