package org.example.productcatalogservice_june2025.controllers;

import org.example.productcatalogservice_june2025.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        //Dummy Response
        Product product = new Product();
        product.setId(1L);
        product.setPrice(1000D);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productList;
    }

    //H/W :  Create a dummy API Wrapper for GetProductById where id will be input
}

