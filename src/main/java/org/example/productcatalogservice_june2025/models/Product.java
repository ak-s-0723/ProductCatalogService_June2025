package org.example.productcatalogservice_june2025.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    //Related to Business
    private Boolean isPrimeSaleSpecific;

    //private Double commisionPerPiece;

}
