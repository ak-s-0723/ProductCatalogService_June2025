package org.example.productcatalogservice_june2025.controllers;

import org.example.productcatalogservice_june2025.dtos.ProductDto;
import org.example.productcatalogservice_june2025.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody
// https://www.baeldung.com/spring-bean-scopes
@RestController
public class ProductController {

    @Autowired
   IProductService productService;


    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return null;
    }

    //Read for @PathVariable , @RequestParam and @QueryParam
    //https://www.baeldung.com/spring-requestparam-vs-pathvariable
    @GetMapping("/products/{id}")
    public  ProductDto getProductById(@PathVariable("id") Long productId) {
      return null;
    }

    @PostMapping("products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
      return productDto;
    }


}

