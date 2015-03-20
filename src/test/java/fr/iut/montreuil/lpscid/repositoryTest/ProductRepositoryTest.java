package fr.iut.montreuil.lpscid.repositoryTest;

import fr.iut.montreuil.lpscid.dao.ProductDao;
import fr.iut.montreuil.lpscid.web.dtoTest.ProductDtoTest;
import fr.iut.montreuil.lpscid.entity.ProductEntity;
import fr.iut.montreuil.lpscid.repository.ProductRepository;
import fr.iut.montreuil.lpscid.web.dto.ProductDto;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mélina on 17/03/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
        public class ProductRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDtoTest.class);
    @Autowired
    private ProductDao productDao;

    @Autowired
    ProductRepository productRepository;

    Mapper mapper;

    // suprimme tous à la fin du test
    @After
    public void tearDown() {
        productRepository.deleteAll();
    }


    // test des méthode CRUD basiques

    @Test
    public void testCRUD() {

        LOGGER.info("Test methodes CRUD");
        Assert.assertEquals(0, productRepository.count());

        ProductDto productDto = new ProductDto(1L, "TestTeeShirt", "shortDesc", 20);

        ProductEntity product = mapper.map(productDto, ProductEntity.class);

        productRepository.save(product);

        // Vérification que le résultat passe à 1
        Assert.assertEquals(1, productRepository.count());

        // Retrouve le produit ajouter et vérifier que le nom est le même
        ProductEntity productloaded = productRepository.findOne(product.getId());
        Assert.assertEquals(productDto.getName(), productloaded.getName());
        // modification du nom
        productloaded.setName("changed named");
        // enregistrement
        productRepository.save(productloaded);
        // vérification que le nombre de résultat est à 1
        Assert.assertEquals(1, productRepository.count());
        productloaded = productRepository.findOne(productDto.getId());
        Assert.assertEquals("changed named", productloaded.getName());


        //Test méthode delete(produit)
        productRepository.delete(productloaded);
        Assert.assertEquals(0, productRepository.count());
    }
}