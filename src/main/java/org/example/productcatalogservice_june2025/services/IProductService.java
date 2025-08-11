package org.example.productcatalogservice_june2025.services;

//ProductContoller      ->  IProductService
//                      ->  fakestoreservice  ->   client   ->    external API (fakestoreapi)
//                      ->  storage service    ->  Jpa/Repo  ->   Storage (Mysql)

import org.example.productcatalogservice_june2025.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Product input,Long id);

    List<Product> getAllProducts(); //ToDo : H/W for learners

    Product getProductDetailsBasedOnUserScope(Long userId,Long productId);
}





