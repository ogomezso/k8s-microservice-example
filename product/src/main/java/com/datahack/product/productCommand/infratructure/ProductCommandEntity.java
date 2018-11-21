package com.datahack.product.productCommand.infratructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity(name = "product")
public class ProductCommandEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "vend_id")
    private Integer vendId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "product_insert_time")
    private Date productInsertTime;

    @PrePersist
    public void setDefaultStatusId() {
        if (productInsertTime == null) {
            productInsertTime = new Date();
        }
    }
}
