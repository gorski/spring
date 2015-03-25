package com.trainings.spring.basic.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trainings.spring.basic.dao.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	private static final Logger LOG = Logger.getLogger(ContactDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addContact(Contact contact) {
		LOG.info("add");
		sessionFactory.getCurrentSession().persist(contact);
	}

	@Override
	public List<Contact> listContact() {
		LOG.info("list");
		
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("from Contact");
		List<Contact> list = query.list();
		LOG.info("fetched " + list.size());
		return list;
	}

	@Override
	public void removeContact(Integer id) {
		
		Contact contact =(Contact) sessionFactory.getCurrentSession().get(Contact.class, id);	
		LOG.info("removing = " +contact);
		if (contact != null){
			sessionFactory.getCurrentSession().delete(contact);
		}
	}
}
