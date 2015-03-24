package com.trainings.service;


import com.trainings.dto.PersonDTO;
import com.trainings.model.Person;

import java.util.List;

public interface PersonService {

    public Person create(PersonDTO created);


    public Person delete(Long personId) throws PersonNotFoundException;

    public List<Person> findAll();

    public Person findById(Long id);

    public Person update(PersonDTO updated) throws PersonNotFoundException;

    public List<Person> searchWithQuery(String name);

    public List<Person> searchWithNamedQuery(String name);


    public List<Person> searchWithCriteria(String name);
}
