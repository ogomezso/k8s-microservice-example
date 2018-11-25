package com.datahack.k8sms.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderQuery {

    private String id;

    private String clientId;

    private String clientName;

    private String promoId;

    private List<Product> products;

    private Date creationDate;

}
