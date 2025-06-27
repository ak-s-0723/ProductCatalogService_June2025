package org.example.productcatalogservice_june2025.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_june2025.models.Product;

import java.util.List;

@Setter
@Getter
public class CategoryDto {
    private Long id;    //ToDo: why are we taking as input
    private String name;
    private String description;
}
