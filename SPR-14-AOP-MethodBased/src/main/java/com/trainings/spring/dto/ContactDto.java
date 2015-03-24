package com.trainings.spring.dto;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.trainings.spring.model.Contact;

public class ContactDto {
	
	public ContactDto() {}
	public ContactDto(Contact contact) {
		this.id = contact.getId();
		this.name = contact.getName();
		this.lastName = contact.getLastName();
	}
	
	private Long id;
	private String name;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
