package fr.iut.montreuil.lpscid.web.dto;

/**
* Created by Mélina on 17/03/15.
*/


public class ProductDto {
	private Long id;
	private String name ;
	private String shortDesc ;
	private double price; 
	


	public ProductDto() {}

	public ProductDto(Long id, String name, String shortDesc, double price) {
		this.id = id;
		this.name = name;
		this.shortDesc = shortDesc;
		this.price = price;

	}

	public static ProductDto newProductDto() {
		return newProductDto();
	}


	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getShortDesc() {return shortDesc;}
	public void setShortDesc(String shortDesc) {this.shortDesc = shortDesc;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
}