package fr.iut.montreuil.lpscid.web.dtoTest;

import fr.iut.montreuil.lpscid.config.DozerConfig;
import fr.iut.montreuil.lpscid.entity.ProductEntity;
import fr.iut.montreuil.lpscid.web.dto.ProductDto;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
/**
 * Created by Mélina on 17/03/2015.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DozerConfig.class})
public class ProductDtoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDtoTest.class);
    @Autowired
    private Mapper mapper;

    ProductDto productDto;

    @Before
    public void setUp() throws Exception {
        // C'est l'instance que l'on va utiliser pour faire nos tests
        productDto = new ProductDto();
    }

    /**
     * -----------------------------------------------------------------------------------
     * Test de la transmission de notre objet vers le DTO correspondant
     * -----------------------------------------------------------------------------------
     */
    @Test
    public void should_SerializeDTOToPojo_OnProduct() {
        Long id = 1L;
        String name = "Tee ShirtTest";
        String shortDesc = "shortDescTest";
        double price = 10.2;

        ProductEntity product = new ProductEntity(id,name,shortDesc,price);
        ProductDto productDto = mapper.map(product, ProductDto.class);

        LOGGER.info("ID product is {}", productDto.getId());
        LOGGER.info("Name product is {}", productDto.getName());
        LOGGER.info("ShortDesc product is {}", productDto.getShortDesc());
        LOGGER.info("Price product is {}", productDto.getPrice());

        Assert.assertThat(productDto, notNullValue());
        Assert.assertEquals(productDto.getId(), id, 1e-8);
        Assert.assertTrue(productDto.getName().equals(name));
        Assert.assertTrue(productDto.getShortDesc().equals(shortDesc));
        Assert.assertEquals(productDto.getPrice(), price, 1e-8);

    }


    @Test
    public void should_SerializePojoToDTO_OnProduct() {

        Long id = 1L;
        String name = "Tee ShirtTest";
        String shortDesc = "shortDescTest";
        double price = 10.2;

        ProductDto productDto = new ProductDto(id,name,shortDesc,price);
        ProductEntity product = mapper.map(productDto, ProductEntity.class);

        LOGGER.info("ID product is {}", product.getId());
        LOGGER.info("Name product is {}", product.getName());
        LOGGER.info("ShortDesc product is {}", product.getShortDesc());
        LOGGER.info("Price product is {}", product.getPrice());

        Assert.assertThat(product, notNullValue());
        Assert.assertEquals(product.getId(), id, 1e-8);
        Assert.assertTrue(product.getName().equals(name));
        Assert.assertTrue(product.getShortDesc().equals(shortDesc));
        Assert. assertEquals(product.getPrice(), price, 1e-8);

    }
}
