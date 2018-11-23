package com.datahack.promos.promosQuery;


import com.datahack.promos.domain.model.ProductQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "promos_query")
@NoArgsConstructor
public class PromoQueryDocument {

    @Id
    private String id;
    private String sellerId;
    private Date timeEnd;
    private Integer quantity;
    private String description;
    private List<ProductQuery> productsQuery;
}
