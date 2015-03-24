package com.trainings.spring.model.dao;

import java.util.List;

import com.trainings.spring.model.Contact;


public interface ContactDao {
	
	  public void addContact(Contact contact);
	  public List<Contact> listContacts();
	  public Contact getContactById(Long id);
	  public void removeContact(Contact contact);

}
