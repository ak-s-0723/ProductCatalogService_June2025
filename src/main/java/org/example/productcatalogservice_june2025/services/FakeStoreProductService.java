package org.example.productcatalogservice_june2025.services;

import org.example.productcatalogservice_june2025.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
