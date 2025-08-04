package org.example.productcatalogservice_june2025.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParam {
    private String sortCriteria;
    private SortType sortType;
}
