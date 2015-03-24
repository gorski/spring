package com.trainings.service;


import com.trainings.dto.PersonDTO;
import com.trainings.model.Person;
import com.trainings.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.trainings.repository.PersonSpecifications.lastNameIsLike;

@Service
public class PersonRepositoryService implements PersonService {

    private static final Logger LOG = Logger.getLogger(PersonRepositoryService.class);

    @Resource
    private PersonRepository personRepository;

    @Override
    public Person create(PersonDTO created) {
        LOG.debug("Creating :" + created);
        Person person =
                Person.getBuilder(created.getFirstName(), created.getLastName()).build();
        return personRepository.save(person);
    }

    @Override
    public Person delete(Long personId) throws PersonNotFoundException {
        Person toDelete = personRepository.findOne(personId);
        if (toDelete == null) {
            throw new PersonNotFoundException();
        }
        personRepository.delete(toDelete);
        return toDelete;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {
        LOG.debug("Finding all persons");
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person findById(Long id) {
        LOG.debug("Finding person by id: " + id);
        return personRepository.findOne(id);
    }

    @Transactional(rollbackFor = PersonNotFoundException.class)
    @Override
    public Person update(PersonDTO updated) throws PersonNotFoundException {
        LOG.debug("Updating person with information: " + updated);

        Person person = personRepository.findOne(updated.getId());

        if (person == null) {
            LOG.debug("No person found with id: " + updated.getId());
            throw new PersonNotFoundException();
        }

        person.update(updated.getFirstName(), updated.getLastName());

        return person;
    }

    @Override
    public List<Person> searchWithQuery(String name) {
        List<Person> byName = personRepository.find(name);
        return byName;
    }

    @Override
    public List<Person> searchWithNamedQuery(String name) {
        List<Person> byName = personRepository.findByName(name);
        return byName;
    }

    @Override
    public List<Person> searchWithCriteria(String name) {
        List<Person> all = personRepository.findAll(lastNameIsLike(name));
        return all;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
