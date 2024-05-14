package com.dependencias.dependencia.repositories;

import com.dependencias.dependencia.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository

public class ProductRepositoryFoo implements ProductRepositoryInt{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(
                new Product(1l,"saco",600l)
        );
    }

    @Override
    public Product findById(Long id) {
        return new Product(1l,"saco",600l);
    }
}
