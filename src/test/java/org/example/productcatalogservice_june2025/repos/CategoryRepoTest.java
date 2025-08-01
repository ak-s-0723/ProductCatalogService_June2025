package org.example.productcatalogservice_june2025.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_june2025.models.Category;
import org.example.productcatalogservice_june2025.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo ;

    //@Test
    //@Transactional //Why I am adding this ?
    public  void testLoading() {
        Optional<Category> categoryOptional = categoryRepo.findById(2L);
        for(Product p : categoryOptional.get().getProducts()) {
            System.out.println(p.getName());
        }
    }

    //@Test
    //@Transactional
    public void testNPlus1() {
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getName());
            }
        }
    }

}