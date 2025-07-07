package org.example.productcatalogservice_june2025.tableInheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User {
    private Long numberOfHours;
}
