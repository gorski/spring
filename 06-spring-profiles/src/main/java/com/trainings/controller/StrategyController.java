package com.trainings.controller;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.Utils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class StrategyController {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(StrategyController.class);

	@Autowired
	Environment environment;

	@Autowired
	Utils util;

	@Autowired
	ApplicationContext context;

	@Autowired
	private CalculationStrategy calculationStrategy;








	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listContacts(Map<String, Object> map) {
		map.put("result", calculationStrategy.execute(
		Integer.valueOf(environment.getProperty("a")),
				Integer.valueOf(environment.getProperty("b"))));

		util.listCtx(context);
		return "/WEB-INF/jsp/strategy.jsp";
	}


}
