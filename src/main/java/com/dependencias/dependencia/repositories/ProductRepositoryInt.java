package com.dependencias.dependencia.repositories;

import com.dependencias.dependencia.model.Product;

import java.util.List;

public interface ProductRepositoryInt {
    List<Product> findAll();

    Product findById(Long id);
}
