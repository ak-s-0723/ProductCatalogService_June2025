package org.example.productcatalogservice_june2025.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_june2025.dtos.ProductDto;
import org.example.productcatalogservice_june2025.models.Product;
import org.example.productcatalogservice_june2025.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception {
        //Arrange
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Iphone24");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        when(productService.getAllProducts()).thenReturn(productList);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Iphone24");
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);


        String response = objectMapper.writeValueAsString(productDtos);
        System.out.println(response);


       mockMvc.perform(get("/products"))
               .andExpect(status().isOk())
               .andExpect(content().string(response));
                //response body == responsestring
    }
}


//object <-> json <-> string