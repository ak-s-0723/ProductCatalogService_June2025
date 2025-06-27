package org.example.productcatalogservice_june2025.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_june2025.models.Category;

@Setter
@Getter
public class ProductDto {
    private Long id;  //ToDo: why are we taking as input

    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private CategoryDto category;
}
