package fr.iut.montreuil.lpscid.web.controller;

import fr.iut.montreuil.lpscid.entity.ProductEntity;
import fr.iut.montreuil.lpscid.service.ProductService;
import fr.iut.montreuil.lpscid.web.dto.ProductDto;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Mélina on 17/03/2015.
 */


@RestController

/*Il est annoté avec RestController .
La différence entre cela et Controller, :moins d'écrire : avec un service Web RESTFUL nous retournons des objets JSON de toute fa�on alors que Controller implique �galement ResponseBody sur chaque m�thode
*/


@RequestMapping("ecommerce/product")

public class ProductRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    // Au lieu de passer directement par le repository on passe par le service
    @Autowired
    private ProductService productService;
    // Déclaration du mapper
    @Autowired
    private Mapper mapper;


    // GET : ecommerce/product : Récupération de la liste des produits
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public Iterable<ProductDto> listProduct(Model model) {
        Iterable<ProductEntity> products = from(productService.getAllProducts()).toList();
        Iterable<ProductDto> productDtos = newArrayList();
        mapper.map(products, productDtos);
        LOGGER.info("List Products is {}", productDtos);
        model.addAttribute("products", productDtos);
        return productDtos;
    }

    // ajout de produits
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    public void add() {
        ProductEntity productEntity = new ProductEntity(1L, "TestTeeShirt", "tee", 10);
        productService.saveProduct(productEntity);
        LOGGER.info("Product add is {}", productEntity);

    }
}