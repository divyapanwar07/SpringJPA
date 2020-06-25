package com.example.spring.database.springdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.spring.database.springdatabase.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person personObj = new Person();
			personObj.setId(rs.getInt("id"));
			personObj.setName(rs.getString("name"));
			personObj.setLocation(rs.getString("location"));
			personObj.setBirth_date(rs.getTimestamp("birth_date"));
			return personObj;
		}
		
	}
	
	// we use query for any type of select query
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
	}
	
	// we use queryForObject if we want to talk about a particular person
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	// whether to delete or update we use update method of jdbc template
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?",new Object[] {id});
	}
	
	public int insertPersonData(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date)"
				+" values (?, ?, ?, ?)", new Object[] {person.getId(), person.getName(),
						person.getLocation(), 
						new Timestamp(person.getBirth_date().getTime())});
	}
	
	public int updatePersonData(Person person) {
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id = ? ",
				new Object[] {
				person.getName(),
				person.getLocation(), 
				new Timestamp(person.getBirth_date().getTime()),
				person.getId()});
	}
}
