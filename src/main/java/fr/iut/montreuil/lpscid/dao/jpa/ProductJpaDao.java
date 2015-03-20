package fr.iut.montreuil.lpscid.dao.jpa;

import fr.iut.montreuil.lpscid.dao.ProductDao;
import fr.iut.montreuil.lpscid.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductJpaDao implements ProductDao {
	/*
	* DI of EntityManager
	*/

	@PersistenceContext(unitName = "lpcsid")
	private EntityManager entityManager;

	@Override

	public List<ProductEntity> getAll() {
		Query query = entityManager.createQuery("FROM "+ ProductEntity.class.getName());
		return (List<ProductEntity>) query.getResultList();
	}

	
	@Override
	public ProductEntity getProductById(Integer id) {
		ProductEntity product = entityManager.find(ProductEntity.class, id);
		return product;
	}

	@Override
		public void update(ProductEntity product) {
		entityManager.merge(product);
	}
}