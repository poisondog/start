package com.example.demo.dao;

import java.util.UUID;
import com.example.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author Adam Huang
 * @since 2020-11-26
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
	@Override
	public int insertPersion(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
	}

	@Override
	public int deletePersonById(UUID id) {
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return Optional.empty();
	}
}
