package fr.iut.montreuil.lpscid.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
* Created by Mélina on 17/03/15.
*/


@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id ;

	@Column(name = "product_name")
	private String name ;
	@Column(name = "product_shortDesc")
	private String shortDesc;
	@Column(name = "product_price")
	private double price; 

	public ProductEntity(){}

 	public ProductEntity(Long id, String name, String shortDesc, double price) {
		this.id = id;
		this.name = name;
		this.shortDesc = shortDesc;
		this.price = price;

	}

 	public static ProductEntity newProductEntity() {
		return newProductEntity();
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getShortDesc() {return shortDesc;}
	public void setShortDesc(String shortDesc) {this.shortDesc = shortDesc;};
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
}