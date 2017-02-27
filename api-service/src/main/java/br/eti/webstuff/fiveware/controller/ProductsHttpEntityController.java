package br.eti.webstuff.fiveware.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.fiveware.model.Products;
import br.eti.webstuff.fiveware.service.ProductsService;

@RestController
@RequestMapping("httpentity/")
public class ProductsHttpEntityController {

	static Logger log = Logger.getLogger(ProductsHttpEntityController.class.getName());

	@Autowired
	private ProductsService service;

	@RequestMapping(value = "search/products/test/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<String> searchProductsByIdTest(@PathVariable(value = "id") int id) {

		log.info("Starting Method searchPersonById.");
		Products products = null;

		HttpHeaders responseHeaders = new HttpHeaders();

		try {
			products = service.searchProductsById(Products.class, id);

			if (products != null) {
				log.info("Method searchProductsById - SEARCH Products: SUCCESS!");
				responseHeaders.set("OK", "200");
				return new HttpEntity<String>("OK", responseHeaders);
			} else {
				log.info("Method searchProductsById - SEARCH Products: NO EXISTS!");
				responseHeaders.set("NO_CONTENT", "204");
				return new HttpEntity<String>("NO_CONTENT", responseHeaders);
			}
		} catch (Exception e) {
			log.info("Method searchProductsById - SEARCH ERROR!");
			responseHeaders.set("BAD_REQUEST", "400");
			return new HttpEntity<String>("BAD_REQUEST", responseHeaders);
		}
	}
	
	
	

}
