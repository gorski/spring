package com.trainings.spring.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trainings.spring.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().persist(contact);
	}

	@Override
	@Transactional
	public List<Contact> listContacts() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Contact");
		List<Contact> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public void removeContact(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);

	}

	@Override
	@Transactional
	public Contact getContactById(Long id) {
		return (Contact) sessionFactory
				.getCurrentSession().get(Contact.class,id);
	}

}
