package com.trainings.spring.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.trainings.spring.basic.dao.ContactDAO;
import com.trainings.spring.basic.dao.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

  @Autowired
  private ContactDAO contactDAO;

//  @Transactional
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED,
		  noRollbackFor = RuntimeException.class)
  public void addContact(Contact contact) {
    contactDAO.addContact(contact);
  }

//  @Transactional
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public List<Contact> listContact() {
    return contactDAO.listContact();
  }

//  @Transactional
  
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public void removeContact(Integer id) {
    contactDAO.removeContact(id);
  }

}
