package com.trainings.spring.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.trainings.spring.dto.ContactDto;

public interface ContactService {

	public void addContact(ContactDto contact);

	public List<ContactDto> listContacts();

	@Secured("ROLE_ADMIN")
	public void removeContact(Long id);

}
