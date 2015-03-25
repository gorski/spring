package com.trainings.spring.basic.service;

import java.util.List;

import com.trainings.spring.basic.dao.model.Contact;

public interface ContactService {

  public void addContact(Contact contact);
  public List<Contact> listContact();
  public void removeContact(Integer id);

}
