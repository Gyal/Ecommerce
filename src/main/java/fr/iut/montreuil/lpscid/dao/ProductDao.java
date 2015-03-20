package fr.iut.montreuil.lpscid.dao;

import fr.iut.montreuil.lpscid.entity.ProductEntity;

import java.util.List;



public interface ProductDao {
	//Returns the list of all products

	public List<ProductEntity> getAll();
	/**
	* Return an product by ID.
	*
	* @param id
	* @return
	*/
	public ProductEntity getProductById(Integer id);
	/**
	* Update the entity
	*
	* @param product
	*/
	public void update(ProductEntity product);
}