package com.trainings.spring.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.trainings.spring.dto.ContactDto;
import com.trainings.spring.service.ContactService;

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

	private static final Logger LOG = Logger.getLogger(ContactController.class);
	
    @Autowired
    private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listContacts() {
		LOG.info("List contacts");
		List<ContactDto> contacts = contactService.listContacts();
		ModelAndView mav = new ModelAndView("contacts");
		mav.addObject("contacts", contacts);
		mav.addObject("contact", new ContactDto());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addContact(
			@ModelAttribute("contact") ContactDto contact, 
			BindingResult result) {

		contactService.addContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeContact(@PathVariable Long id) {
		LOG.info("Remove contact with ID: " +id );

		contactService.removeContact(id);
		return "redirect:/contacts";
//		 new ModelAndView("redirect:contacts");
//		return new RedirectView("/contacts");
	}
}
