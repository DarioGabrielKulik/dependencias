package com.dependencias.dependencia.services;

import com.dependencias.dependencia.model.Product;
import com.dependencias.dependencia.repositories.ProductRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService implements ProductServiceInt{

    @Value("${config.impuesto}")
    Double impuesto;

    @Autowired
    private Environment enviroment;

    private ProductRepositoryInt productsRepositorie;

    public ProductsService( ProductRepositoryInt productsRepositorie) {
        this.productsRepositorie = productsRepositorie;
    }

    public List<Product> findAll(){
        return productsRepositorie.findAll().stream().map(p -> {

            Double priceImp = p.getPrice() * impuesto;
            //new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProduct =(Product) p.clone();
            newProduct.setPrice(priceImp.longValue());
            System.out.println(impuesto);
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return productsRepositorie.findById(id);
    }

}
