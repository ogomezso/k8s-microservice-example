package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "orders")
class OrderCommandEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID orderId;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "promo_id")
    private String promoId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "creationDate")
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date orderCreationTime;

    @PrePersist
    public void setDefaultStatusId() {
        if (orderCreationTime == null) {
            orderCreationTime = new Date();
        }
    }
}
