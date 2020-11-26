package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Huang
 * @since 2020-11-24
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personService;

	/**
	 * Constructor
	 */
	@Autowired
	public PersonController(PersonService service) {
		personService = service;
	}

	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping(path = "{pid}")
	public Person getPersonById(@PathVariable("pid") UUID id) {
		return personService.getPersonById(id).orElse(null);
	}

	@DeleteMapping(path = "{pid}")
	public void deletePersonById(@PathVariable("pid") UUID id) {
		personService.deletePerson(id);
	}

	@PutMapping(path = "{pid}")
	public void updatePerson(@PathVariable("pid") UUID id, @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}
}
