package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

/**
 * @author Adam Huang
 * @since 2020-11-24
 */
public interface PersonDao {
	int insertPersion(UUID id, Person person);

	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPersion(id, person);
	}
	List<Person> selectAllPeople();
	int deletePersonById(UUID id);
	int updatePersonById(UUID id, Person person);
	Optional<Person> selectPersonById(UUID id);
}
