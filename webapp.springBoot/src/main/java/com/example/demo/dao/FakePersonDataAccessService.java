package com.example.demo.dao;

import java.util.UUID;
import com.example.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author Adam Huang
 * @since 2020-11-24
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	private static List<Person> DB = new ArrayList<Person>();

	@Override
	public int insertPersion(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> maybe = selectPersonById(id);
		if (maybe.isEmpty()) {
			return 0;
		}
		DB.remove(maybe.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return selectPersonById(id).map(p -> {
			int index = DB.indexOf(p);
			if (index >= 0) {
				DB.set(index, new Person(id, person.getName()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
}
