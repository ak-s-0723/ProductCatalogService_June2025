package org.example.productcatalogservice_june2025.tableInheritanceExamples.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name="user_id_")
public class Ta extends User {
    private Long numberOfRatings;
}
