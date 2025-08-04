package org.example.productcatalogservice_june2025.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category",fetch= FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size=2)
    @JsonBackReference
    private List<Product> products;
}


//FetchType help in determining at what time (when), child entity will be
// loaded from Db to RAM

//FetchMode will help us in deciding how to get the data (join , subquery or select)