package com.example.demo.model;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Adam Huang
 * @since 2020-11-24
 */
public class Person {
	private final UUID id;
	@NotBlank
	private final String name;

	/**
	 * Constructor
	 */
	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
