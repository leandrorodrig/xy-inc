package br.eti.webstuff.web.model;


import java.util.List;

import br.eti.webstuff.web.jsonview.Views;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxProductsResponseBody {
	
	
	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	Products products;
	
	
	@JsonView(Views.Public.class)
    List<Products> listProducts;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}

	@Override
	public String toString() {
		return "AjaxProductsResponseBody [msg=" + msg + ", code=" + code
				+ ", products=" + products + ", listProducts=" + listProducts
				+ "]";
	}

	
	
	
}
