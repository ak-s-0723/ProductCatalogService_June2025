package org.example.productcatalogservice_june2025.tableInheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instructor")
public class Instructor extends User {
    private String companyName;
}
