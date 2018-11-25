package com.datahack.k8sms.orders.domain.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderCommand {

    private String id;
    @NonNull
    private String clientId;
    @NonNull
    private String promoId;
    @NonNull
    private Integer quantity;
}
