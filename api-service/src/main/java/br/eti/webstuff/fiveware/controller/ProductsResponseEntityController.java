package br.eti.webstuff.fiveware.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.fiveware.model.Products;
import br.eti.webstuff.fiveware.service.ProductsService;

@RestController
@RequestMapping("/")
public class ProductsResponseEntityController {

	static Logger log = Logger.getLogger(ProductsResponseEntityController.class
			.getName());

	@Autowired
	private ProductsService service;

	@RequestMapping(value = "saveProductsbody", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> saveProducts(@RequestBody Products products) {

		log.info("Starting Method saveProducts.");

		try {
			service.save(products);
			log.info("Method saveProducts - SAVE Products: SUCCESS!");
			return new ResponseEntity<Products>(products, HttpStatus.CREATED);
		} catch (Exception e) {
			log.info("Method saveProducts  - SAVE Products: ERROR!");
			return new ResponseEntity<Products>(products,
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "update/products", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> updateProductsbody(
			@RequestBody Products products) {

		log.info("Starting Method updatePerson.");
		try {
			service.update(products);
			log.info("Method updatePerson - UPDATE Products: SUCCESS!");
			return new ResponseEntity<Products>(products, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.info("Method updateProductsbody  - UPDATE Products: ERROR!");
			return new ResponseEntity<Products>(products, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "search/products/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> searchProductsById(
			@PathVariable(value = "id") int id) {

		log.info("Starting Method searchPersonById.");
		Products products = null;
		try {
			products = service.searchProductsById(Products.class, id);

			if (products != null) {
				log.info("Method searchProductsById - SEARCH Products: SUCCESS!");
				return new ResponseEntity<Products>(products, HttpStatus.OK);
			} else {
				log.info("Method searchProductsById - SEARCH Products: NO EXISTS!");
				return new ResponseEntity<Products>(products,
						HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.info("Method searchProductsById - SEARCH ERROR!");
			return new ResponseEntity<Products>(products, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "delete/products/id/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Products> deleteProductsById(
			@PathVariable(value = "id") String id) {

		log.info("Starting Method deleteProductsById.");
		Products products = null;

		try {
			products = service.searchProductsById(id.trim());

			if (products != null) {

				Integer idProducts = Integer.parseInt(id.trim());
				service.delete(Products.class, idProducts);

				log.info("Method deleteProductsById - DELETE Products: SUCCESS!");
				return new ResponseEntity<Products>(products,
						HttpStatus.ACCEPTED);

			} else {
				log.info("Method searchProductsById - SEARCH Products: NO EXISTS!");
				return new ResponseEntity<Products>(products,
						HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			log.info("Method deleteProductsById - ERROR Products: NO EXISTS!");
			return new ResponseEntity<Products>(products, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "search/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> searchProducts() {

		log.info("Starting Method searchPeople.");

		List<Products> listProducts = service.searchListProducts();

		if (!listProducts.isEmpty()) {

			log.info("Method searchProducts - SEARCH ALLS Products: SUCCESS!");
			return new ResponseEntity<List<Products>>(listProducts,
					HttpStatus.OK);
		} else {
			log.info("Method searchProducts - SEARCH ALLS Products: NO EXISTS!");
			return new ResponseEntity<List<Products>>(listProducts,
					HttpStatus.NO_CONTENT);
		}
	}
	
	

}
