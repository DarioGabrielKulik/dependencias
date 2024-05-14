package com.dependencias.dependencia.controllers;

import com.dependencias.dependencia.model.Product;
import com.dependencias.dependencia.services.ProductServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    ProductServiceInt productsService;

@GetMapping("/list")
    public List<Product> list(){
    return productsService.findAll();
}

@GetMapping("/{id}")
    public Product product(@PathVariable Long id){
    return productsService.findById(id);
}

}
