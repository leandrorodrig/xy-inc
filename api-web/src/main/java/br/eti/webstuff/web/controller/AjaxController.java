package br.eti.webstuff.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.eti.webstuff.web.jsonview.Views;
import br.eti.webstuff.web.model.AjaxProductsResponseBody;
import br.eti.webstuff.web.model.Products;
import br.eti.webstuff.web.model.ProductsVO;
import br.eti.webstuff.web.model.SearchProductsCriteria;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class AjaxController {

	private boolean isValidSearchProductsCriteria(SearchProductsCriteria search) {
		boolean valid = true;
		if (search == null) {
			valid = false;
		}
		if ((StringUtils.isEmpty(search.getName()))
				&& (StringUtils.isEmpty(search.getDescription()))
				&& (StringUtils.isEmpty(search.getCategory()))) {
			valid = false;
		}
		return valid;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/save/products", method = RequestMethod.POST)
	public AjaxProductsResponseBody saveProductsWithAjax(
			@RequestBody SearchProductsCriteria search) {

		AjaxProductsResponseBody result = new AjaxProductsResponseBody();

		if (isValidSearchProductsCriteria(search)) {

			RestTemplate restTemplate = new RestTemplate();

			final String uri = "http://localhost:8085/fiveware-test-service/saveProductsbody";

			ProductsVO productsVO = new ProductsVO();

			productsVO.setName(search.getName());
			productsVO.setDescription(search.getDescription());
			productsVO.setCategory(search.getCategory());

			String priceUI = search.getPrice();
			Double price = Double.parseDouble(priceUI);
			productsVO.setPrice(price);

			ProductsVO vo = restTemplate.postForObject(uri, productsVO, ProductsVO.class);

			Products products = new Products();

			products.setName(productsVO.getName());
			products.setDescription(productsVO.getDescription());
			products.setCategory(productsVO.getCategory());

			products.setPrice(productsVO.getPrice());

			if (products != null) {
				result.setCode("201");
				result.setMsg("OK");
				result.setProducts(products);
			} else {
				result.setCode("204");
				result.setMsg("No Products!");
			}
		} else {
			result.setCode("400");
			result.setMsg("Products is empty!!");
		}
		return result;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getProductsById")
	public AjaxProductsResponseBody getProductsByIdViaAjax(
			@RequestBody SearchProductsCriteria search) {

		AjaxProductsResponseBody result = new AjaxProductsResponseBody();

		if (search.getId() != null) {

			Integer idProducts = Integer.parseUnsignedInt(search.getId());

			Products products = new Products();

			RestTemplate restTemplate = new RestTemplate();

			String uri = "http://localhost:8085/fiveware-test-service/search/products/id/{id}";

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>("Products",
					headers);

			ResponseEntity<ProductsVO> productsEntity = restTemplate.exchange(
					uri, HttpMethod.GET, entity, ProductsVO.class, idProducts);

			products.setId(productsEntity.getBody().getId()); 						
			products.setName(productsEntity.getBody().getName());
			products.setDescription(productsEntity.getBody().getDescription());
			products.setCategory(productsEntity.getBody().getCategory());
			products.setPrice(productsEntity.getBody().getPrice());

			if (products != null) {
				result.setCode("200");
				result.setMsg("OK");
				result.setProducts(products);
			} else {
				result.setCode("204");
				result.setMsg("No products!");
			}
		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		return result;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/updateproducts", method = RequestMethod.PUT)
	public AjaxProductsResponseBody updateProductsWithAjax(@RequestBody SearchProductsCriteria search) {

		AjaxProductsResponseBody result = null;

		if (isValidSearchProductsCriteria(search)) {

			result = new AjaxProductsResponseBody();

			RestTemplate restTemplate = new RestTemplate();

			final String uri = "http://localhost:8085/fiveware-test-service/update/products";
			
			                                                
			ProductsVO productsVO = new ProductsVO();
			
			Integer productId = Integer.parseInt(search.getId()); 

			productsVO.setId(productId);

			productsVO.setName(search.getName());
			productsVO.setDescription(search.getDescription());
			productsVO.setCategory(search.getCategory());

			String priceUI = search.getPrice();
			Double price = Double.parseDouble(priceUI);
			productsVO.setPrice(price); 
			
			Map<String, String> params = new HashMap<String, String>();
		    params.put("id", search.getId());
		    params.put("name", search.getName());
		    params.put("description", search.getDescription());
		    params.put("category", search.getCategory());	
		    params.put("price", search.getPrice());	  
		    
		    restTemplate.put ( uri, productsVO, params);
			
			Products products = new Products();

			products.setName(productsVO.getName());
			products.setDescription(productsVO.getDescription());
			products.setCategory(productsVO.getCategory());
			products.setPrice(productsVO.getPrice());
			products.setId(productsVO.getId());

			if (products != null) { 
				result.setCode("200");
				result.setMsg("OK");
				result.setProducts(products);
			} else {
				result.setCode("204");
				result.setMsg("No Products!");
			}
		} else {
			result.setCode("400");
			result.setMsg("Products is empty!!");
		}
		return result;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/deleteProductsById")
	public AjaxProductsResponseBody deleteProductsByIdViaAjax(
			@RequestBody SearchProductsCriteria search) {

		AjaxProductsResponseBody result = new AjaxProductsResponseBody();

		if (search.getId().trim() != null) {

			Integer idProducts = Integer.parseUnsignedInt(search.getId());

			RestTemplate restTemplate = new RestTemplate();

			String uri = "http://localhost:8085/fiveware-test-service/delete/products/id/{id}";

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>("Products",
					headers);

			ResponseEntity<ProductsVO> productsEntity = restTemplate.exchange(uri, HttpMethod.DELETE, entity, ProductsVO.class, idProducts);

			if (productsEntity.getStatusCode().is2xxSuccessful()) {
				result.setCode("202");
				result.setMsg("accepted");
			} else if (productsEntity.getStatusCode().is4xxClientError()) {
				result.setCode("404");
				result.setMsg("No Exists Products!");
			} else {
				result.setCode("408");
				result.setMsg("Request Timeout!");
			}
		} else {
			result.setCode("400");
			result.setMsg("ID of Products is empty!");
		}
		return result;
	}

}
