package br.eti.webstuff.fiveware.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	static Logger log = Logger.getLogger(HomeController.class.getName());

	@RequestMapping("/")
	public String index() {
		log.info("Starting API - fiveware-test-service.");
		return "home";
	}
	
}
