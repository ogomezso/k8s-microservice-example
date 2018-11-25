package com.datahack.k8sms.product.productQuery.infrastructure;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "products_query")
@NoArgsConstructor
public class ProductDocument {

    @Id
    private String id;
    private String productName;
    private String vendId;
    private Integer quantity;
    private Double price;
    private Date expirationDate;
}
