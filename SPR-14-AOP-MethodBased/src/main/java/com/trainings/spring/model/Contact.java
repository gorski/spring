package com.trainings.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.trainings.spring.dto.ContactDto;

@Entity
public class Contact {

	public Contact() {
	}

	public Contact(ContactDto dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.lastName = dto.getLastName();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String lastName;
	private Date created;

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	@PrePersist
	private void foo() {
		created = new Date();
	}

}
