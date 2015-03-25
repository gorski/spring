package com.trainings.controller;

import com.trainings.dto.PersonDTO;
import com.trainings.dto.PersonSearchDto;
import com.trainings.model.Person;
import com.trainings.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/ajax")
public class PersonAjaxController {

    private static final Logger LOG = Logger.getLogger(PersonAjaxController.class);

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/")
    public String showCreatePersonForm(Model model) {
        return "ajax";
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @Transactional(readOnly = true)
    public List<PersonDTO> searchPersonWithAjax(@RequestBody PersonSearchDto person) {
        List<Person> persons = personService.searchWithQuery("%" + person.getSearch() + "%");

        List<PersonDTO> list = new LinkedList<PersonDTO>();
        for (Person person1 : persons) {
            PersonDTO personDto = new PersonDTO();

            personDto.setFirstName(person1.getFirstName());
            personDto.setLastName(person1.getLastName());

            // TODO: other fields

            list.add(personDto);
        }

        return list;
    }
}
