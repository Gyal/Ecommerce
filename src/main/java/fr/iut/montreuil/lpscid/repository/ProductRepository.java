package fr.iut.montreuil.lpscid.repository;

import fr.iut.montreuil.lpscid.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
* Created by M�lina on 17/03/2015.
*/
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity save(ProductEntity prod);
}