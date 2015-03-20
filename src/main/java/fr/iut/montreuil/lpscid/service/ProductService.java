package fr.iut.montreuil.lpscid.service;

import fr.iut.montreuil.lpscid.entity.ProductEntity;
import fr.iut.montreuil.lpscid.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
/**
* Created by Mélina on 17/03/2015.
* grâce au service, l'application ne s'interesse pas à l'implementation des mécanisme qui doivent rester "invisible".
* Ainsi même si ces mécanismes changent cela n'impactera pas le code de l'application.
*/


@Service
@Transactional
public class ProductService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	private final ProductRepository productRepository;

	@Inject
	public ProductService(final ProductRepository productRepository) {
	this.productRepository = productRepository;
	}

	public ProductEntity saveProduct(final ProductEntity productEntity) {return productRepository.save(productEntity);}

	public void deleteProduct(Long id) {productRepository.delete(id);}

	public Iterable<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	public ProductEntity getProductById(Long id) {
		return productRepository.findOne(id);
	}

}
