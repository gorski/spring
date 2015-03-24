package com.trainings.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.trainings.spring.dto.ContactDto;
import com.trainings.spring.model.Contact;
import com.trainings.spring.model.dao.ContactDao;

@Service
public class ContactServiceImpl implements ContactService {

	private static final Logger LOG = Logger.getLogger(ContactServiceImpl.class);
	
	
	@Autowired
	private ContactDao contactDao;
	
	@Override
	public void addContact(ContactDto contactDto) {
		contactDao.addContact(new Contact(contactDto));
	}

	@Override
	public List<ContactDto> listContacts() {
		List<Contact> contacts = contactDao.listContacts();
		List<ContactDto> contactsDto = new ArrayList<ContactDto>(contacts.size());
		for (Contact c : contacts){
			contactsDto.add(new ContactDto(c));
		}
		return contactsDto;
	}

	@Override
	public void removeContact(Long id) {
		Contact contact = contactDao.getContactById(id);
		LOG.info("Removing contact:"+ contact);
		contactDao.removeContact(contact);
	}

}
