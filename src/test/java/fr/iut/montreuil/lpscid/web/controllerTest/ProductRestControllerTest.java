package fr.iut.montreuil.lpscid.web.controllerTest;

import fr.iut.montreuil.lpscid.config.DozerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Mélina on 17/03/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DozerConfig.class})
public class ProductRestControllerTest {

    ProductRestControllerTest product;
    private MockMvc mockMvc;




    @Test
    public void testListProduct() throws Exception {
        this.mockMvc.perform(get("/ecommerce/product/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}

