package br.eti.webstuff.web.model;

import br.eti.webstuff.web.jsonview.Views;

import com.fasterxml.jackson.annotation.JsonView;

public class Products {
	
	@JsonView(Views.Public.class)
	private Integer id;
	
	@JsonView(Views.Public.class)
	private String name;
	
	@JsonView(Views.Public.class)
	private String description;
	
	@JsonView(Views.Public.class)
	private String category;
	
	@JsonView(Views.Public.class)
	private Double price;
	
	
	public Products() {
	}
	
	
	public Products(String name, String description, String category, Double price, Integer id) {
		super();
		
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description="
				+ description + ", category=" + category + ", price=" + price
				+ "]";
	}
	
}
