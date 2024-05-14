package com.dependencias.dependencia.configurations;

import com.dependencias.dependencia.repositories.ProductsRepositoriesJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:impuesto.properties")
public class AllConfiguration {

    @Bean
    @Primary
    ProductsRepositoriesJson productsRepositoriesJson(){
        return new ProductsRepositoriesJson();
    }
}
