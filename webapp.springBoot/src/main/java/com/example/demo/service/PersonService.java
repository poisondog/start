package com.example.demo.service;

import java.util.UUID;
import com.example.demo.model.Person;
import com.example.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Adam Huang
 * @since 2020-11-24
 */
@Service
public class PersonService {
	private final PersonDao personDao;

	/**
	 * Constructor
	 */
	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}

	public List<Person> getAllPeople() {
		return personDao.selectAllPeople();
	}

	public Optional<Person> getPersonById(UUID id) {
		return personDao.selectPersonById(id);
	}
}
