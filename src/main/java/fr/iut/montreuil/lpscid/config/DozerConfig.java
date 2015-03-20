package fr.iut.montreuil.lpscid.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by Mélina on 17/03/2015.
 */@Configuration
   public class DozerConfig {

    @Bean
    public Mapper dozerBeanMapper() {
        return new DozerBeanMapper(Arrays.asList("dozer-mapping.xml"));
    }
}

