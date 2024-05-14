package com.dependencias.dependencia.repositories;

import com.dependencias.dependencia.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoriesJson implements ProductRepositoryInt{

    public ProductsRepositoriesJson()  {
      Resource resour = new ClassPathResource("product.json");
        ObjectMapper mapa = new ObjectMapper();
        try {
            list = Arrays.asList(mapa.readValue(resour.getFile(), Product[].class ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> list;

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElseThrow();
    }
}
