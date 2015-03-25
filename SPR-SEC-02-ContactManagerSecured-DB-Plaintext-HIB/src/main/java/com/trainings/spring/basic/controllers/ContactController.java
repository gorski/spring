package com.trainings.spring.basic.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trainings.spring.basic.dao.model.Contact;
import com.trainings.spring.basic.service.ContactService;

@Controller
public class ContactController {

	private static final Logger LOG = Logger.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;

	@Autowired
	ApplicationContext ctx;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		
		LOG.info("index");

//		listCtx(ctx);

		return "contact";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}

	
	@ExceptionHandler(Throwable.class)
	  public ModelAndView handleNullPointerException(Throwable ex) {
		
	    LOG.error(ex);
		ModelAndView err = new ModelAndView("wtf");
		err.addObject("error", ex.getMessage());
	    
	    return err;
	  }

}
