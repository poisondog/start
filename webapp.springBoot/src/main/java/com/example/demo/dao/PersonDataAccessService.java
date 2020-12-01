package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Adam Huang
 * @since 2020-11-26
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
	private final JdbcTemplate jdbcTemplate;

	/**
	 * Constructor
	 */
	@Autowired
	public PersonDataAccessService(JdbcTemplate template) {
		jdbcTemplate = template;
	}

	@Override
	public int insertPersion(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		final String sql = "SELECT id, name FROM person";
		List<Person> people = jdbcTemplate.query(sql, (result, i) -> {
			UUID id = UUID.fromString(result.getString("id"));
			return new Person(id, result.getString("name"));
		});
		return people;
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
		final String sql = "SELECT id, name FROM person WHERE id = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (result, i) -> {
			UUID pid = UUID.fromString(result.getString("id"));
			return new Person(pid, result.getString("name"));
		});
		return Optional.ofNullable(person);
	}
}
