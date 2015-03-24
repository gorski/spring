package com.trainings.controller;


import com.trainings.dto.PersonDTO;
import com.trainings.model.Person;
import com.trainings.service.PersonNotFoundException;
import com.trainings.service.PersonService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@Controller
@SessionAttributes("person")
public class PersonController extends AbstractController {
    private static final Logger LOG = Logger.getLogger(PersonController.class);

    protected static final String ERROR_MESSAGE_KEY_DELETED_PERSON_WAS_NOT_FOUND = "error.message.deleted.not.found";
    protected static final String ERROR_MESSAGE_KEY_EDITED_PERSON_WAS_NOT_FOUND = "error.message.edited.not.found";

    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_CREATED = "feedback.message.person.created";
    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_DELETED = "feedback.message.person.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_EDITED = "feedback.message.person.edited";

    protected static final String MODEL_ATTIRUTE_PERSON = "person";
    protected static final String MODEL_ATTRIBUTE_PERSONS = "persons";

    protected static final String PERSON_ADD_FORM_VIEW = "person/create";
    protected static final String PERSON_EDIT_FORM_VIEW = "person/edit";
    protected static final String PERSON_LIST_VIEW = "person/list";

    protected static final String REQUEST_MAPPING_LIST = "/";

    @Resource
    private PersonService personService;


    private PersonDTO constructFormObject(Person person) {
        PersonDTO formObject = new PersonDTO();

        formObject.setId(person.getId());
        formObject.setFirstName(person.getFirstName());
        formObject.setLastName(person.getLastName());

        return formObject;
    }

    @RequestMapping(value = REQUEST_MAPPING_LIST, method = RequestMethod.GET)
    public String showList(Model model) {
        LOG.debug("Rendering person list page");
        List<Person> persons = personService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_PERSONS, persons);
        return PERSON_LIST_VIEW;
    }


    protected void setPersonService(PersonService personService) {
        this.personService = personService;
    }


    @ResponseBody
    @RequestMapping(
            value = "/person/searchQuery/{query}",
            method = RequestMethod.GET)
    public List<Person> searchPerson(@PathVariable("query") String query) {
        List<Person> persons = personService.searchWithQuery(query);
        LOG.info(persons);
        return persons;
    }

    @ResponseBody
    @RequestMapping(
            value = "/person/searchNamedQuery/{query}",
            method = RequestMethod.GET)
    public List<Person> searchPersonNamedQuery(@PathVariable("query") String query) {
        List<Person> persons = personService.searchWithNamedQuery(query);
        LOG.info(persons);
        return persons;
    }

    @ResponseBody
    @RequestMapping(
            value = "/person/searchCriteria/{query}",
            method = RequestMethod.GET)
    public List<Person> searchPersonCriteria(@PathVariable("query") String query) {
        List<Person> persons = personService.searchWithCriteria(query);
        LOG.info(persons);
        return persons;
    }


    @RequestMapping(value = "/person/delete/{id}", method = RequestMethod.GET)
    public RedirectView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        LOG.debug("Deleting person with id: " + id);

        try {
            Person deleted = personService.delete(id);
            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_DELETED, deleted.getName());
        } catch (PersonNotFoundException e) {
            LOG.debug("No person found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_PERSON_WAS_NOT_FOUND);
        }

        return new RedirectView("/");
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.GET)
    public ModelAndView showCreatePersonForm(Model model) {
        LOG.debug("Rendering create person form");

        model.addAttribute(MODEL_ATTIRUTE_PERSON, new PersonDTO());

        return new ModelAndView(PERSON_ADD_FORM_VIEW);
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.POST)
    public ModelAndView submitCreatePersonForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_PERSON) PersonDTO created, BindingResult bindingResult, RedirectAttributes attributes) {
        LOG.debug("Create person form was submitted with information: " + created);

        if (bindingResult.hasErrors()) {
            return new ModelAndView(PERSON_ADD_FORM_VIEW);
        }

        Person person = personService.create(created);

        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_CREATED, person.getName());

        return new ModelAndView("redirect:"+REQUEST_MAPPING_LIST);
    }


    @RequestMapping(value = "/person/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditPersonForm(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        LOG.debug("Rendering edit person form for person with id: " + id);

        Person person = personService.findById(id);
        if (person == null) {
            LOG.debug("No person found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_PERSON_WAS_NOT_FOUND);
            return new ModelAndView("redirect:"+REQUEST_MAPPING_LIST);
        }

        model.addAttribute(MODEL_ATTIRUTE_PERSON, constructFormObject(person));

        return new ModelAndView(PERSON_EDIT_FORM_VIEW);
    }


    @RequestMapping(value = "/person/edit", method = RequestMethod.POST)
    public ModelAndView submitEditPersonForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_PERSON) PersonDTO updated, BindingResult bindingResult, RedirectAttributes attributes) {
        LOG.debug("Edit person form was submitted with information: " + updated);

        if (bindingResult.hasErrors()) {
            LOG.debug("Edit person form contains validation errors. Rendering form view.");
            return new ModelAndView(PERSON_EDIT_FORM_VIEW);
        }

        try {
            Person person = personService.update(updated);
            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_EDITED, person.getName());
        } catch (PersonNotFoundException e) {
            LOG.debug("No person was found with id: " + updated.getId());
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_PERSON_WAS_NOT_FOUND);
        }

        return new ModelAndView("redirect:"+REQUEST_MAPPING_LIST);
    }
}
