package fr.iut.montreuil.lpscid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EcommerceApplication.class)
@WebAppConfiguration
@EnableAutoConfiguration
@PropertySource("classpath:hibernate.properties")
public class EcommerceTpApplicationTests {

	@Test
	public void contextLoads() {
	}

}
