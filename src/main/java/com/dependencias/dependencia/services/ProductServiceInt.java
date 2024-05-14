package com.dependencias.dependencia.services;

import com.dependencias.dependencia.model.Product;

import java.util.List;

public interface ProductServiceInt {

    List<Product> findAll();

    Product findById(Long id);
}
