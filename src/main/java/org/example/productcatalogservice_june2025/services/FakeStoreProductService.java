package org.example.productcatalogservice_june2025.services;

import org.example.productcatalogservice_june2025.clients.FakeStoreApiClient;
import org.example.productcatalogservice_june2025.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_june2025.dtos.ProductDto;
import org.example.productcatalogservice_june2025.models.Category;
import org.example.productcatalogservice_june2025.models.Product;
import org.example.productcatalogservice_june2025.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product getProductById(Long id) {
      RestTemplate restTemplate = restTemplateBuilder.build();

      //if(found in redis)
      //  return
      //else
      //call fakestore
      //cache it
      //return it

      FakeStoreProductDto fakeStoreProductDto = null;

     fakeStoreProductDto= (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS",id);

     if(fakeStoreProductDto == null) {
         System.out.println("Not found in Redis");
         fakeStoreProductDto =
                 restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                         FakeStoreProductDto.class, id).getBody();

         redisTemplate.opsForHash().put("PRODUCTS",id,fakeStoreProductDto);

//      FakeStoreProductDto fakeStoreProductDto =
//              fakeStoreProductDtoResponseEntity.getBody();

//      if(fakeStoreProductDto != null &&
//              fakeStoreProductDtoResponseEntity.getStatusCode() ==
//                      HttpStatus.valueOf(200)) {
         return from(fakeStoreProductDto);
         //     }
     } else {
         System.out.println("Found in Redis");
         return from(fakeStoreProductDto);
     }

      //return null;
    }

    @Override
    public Product createProduct(Product input) {
        FakeStoreProductDto fakeStoreProductDtoInput = from(input);

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products",
                fakeStoreProductDtoInput, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDtoOutput =
                fakeStoreProductDtoResponseEntity.getBody();

        if(fakeStoreProductDtoOutput != null &&
                fakeStoreProductDtoResponseEntity.getStatusCode() ==
                        HttpStatus.valueOf(200)) {
            return from(fakeStoreProductDtoOutput);
        }

        return null;
    }

    public Product replaceProduct(Product input,Long id) {
        FakeStoreProductDto fakeStoreProductDtoInput = from(input);
        FakeStoreProductDto output = fakeStoreApiClient.replaceFakeStoreProduct(fakeStoreProductDtoInput,id);
        if(output==null) return null;
        return from(output);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductDetailsBasedOnUserScope(Long userId, Long productId) {
        return null;
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
