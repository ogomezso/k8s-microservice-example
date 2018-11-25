package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "orders_query")
@NoArgsConstructor
class OrderQueryDocument {


    @Id
    private String id;

    private String clientId;

    private String clientName;

    private String promoId;

    private List<Product> products;

    private Date creationDate;

}
