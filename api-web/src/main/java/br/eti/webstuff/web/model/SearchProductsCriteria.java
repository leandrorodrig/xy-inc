package br.eti.webstuff.web.model;

public class SearchProductsCriteria {
	
	
	private String id;
	private String name;
	private String description;
	private String category;
	private String price;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "SearchProductsCriteria [id=" + id + ", name=" + name
				+ ", description=" + description + ", category=" + category
				+ ", price=" + price + "]";
	}
	
}
