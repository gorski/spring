package com.trainings.service;


import com.trainings.dto.PersonDTO;
import com.trainings.model.Address;
import com.trainings.model.MobilePhone;
import com.trainings.model.Person;
import com.trainings.repository.AddressRepository;
import com.trainings.repository.MobilePhoneRepository;
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
    @Resource
    AddressRepository addressRepository;

    @Resource
    MobilePhoneRepository mobilePhoneRepository;

//    @Override
//    public Person create(PersonDTO created) {
//        LOG.debug("Creating :" + created);
//        Person person =
//                Person.getBuilder(created.getFirstName(), created.getLastName()).build();
//        return personRepository.save(person);
//    }

    @Override
    @Transactional
    public Person create(PersonDTO created) {
        LOG.debug("Creating :" + created);
        Person person =
                Person.getBuilder(created.getFirstName(), created.getLastName()).build();

        // 1st, save master of the relation
        Person savedPerson = personRepository.save(person);

        // adding address
        final String address = created.getAddress();
        if (address != null && !address.trim().isEmpty()) {
            Address a = new Address();
            a.setPerson(savedPerson);
            a.setCity(address);
            addressRepository.save(a);
            LOG.info("Added address " + a);
        } else {
            LOG.info("Address empty");
        }

        // adding phone(s)
        final List<String> phones = created.getPhones();
        if (phones != null && phones.size() > 0) {

            for (String phoneNo : phones) {
                if (!phoneNo.trim().isEmpty()) {
                    final MobilePhone mobilePhone = new MobilePhone();
                    mobilePhone.setPhoneNumber(phoneNo);
                    mobilePhone.setPerson(person);
                    mobilePhoneRepository.save(mobilePhone);
                    LOG.info("Added mobile phone " + mobilePhone);
                }
            }
        } else {
            LOG.info("Phone(s) empty");
        }


        return person;
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
