package br.eti.webstuff.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initProducts(ModelMap model) {
		return "create-products";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String saveProducts(ModelMap model) {
		return "create-products";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteProducts(ModelMap model) {
		return "delete-products";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateProducts(ModelMap model) {
		return "update-products";
	}
	
}
