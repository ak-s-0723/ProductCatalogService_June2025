package org.example.productcatalogservice_june2025.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class FakeStoreProductDto implements Serializable {
    private String title;
    private String description;
    private String category;
    private String image;
    private Long id;
    private Double price;
}
