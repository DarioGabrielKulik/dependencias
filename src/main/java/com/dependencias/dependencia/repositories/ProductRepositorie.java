package com.dependencias.dependencia.repositories;

import com.dependencias.dependencia.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Repository
// @RequestScope // vale una peticion
//@SessionScope // hasta que se cierre la pestaña
public class ProductRepositorie implements ProductRepositoryInt{

    private List<Product> product;


    public ProductRepositorie() {
        this.product = Arrays.asList(
                new Product(1l, "pc", 25000l),
                new Product(2l,"notebook", 45000l),
                new Product(3l,"tablet",13000l),
                new Product(4l, "celular", 27812l)
                );
    }

    public List<Product> findAll() {
        return product;
    }

    public Product findById(Long id){
        return product.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
