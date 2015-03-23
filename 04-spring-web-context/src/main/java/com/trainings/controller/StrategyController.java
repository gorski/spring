package com.trainings.controller;

import com.trainings.basic.CalculationStrategy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class StrategyController {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(StrategyController.class);

	@Autowired
	private CalculationStrategy calculationStrategy;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listContacts(Map<String, Object> map) {
		map.put("result", calculationStrategy.execute(1,2));
		return "/WEB-INF/jsp/strategy.jsp";
	}


}
