package com.datahack.k8sms.promos.promosCommand;


import com.fasterxml.jackson.annotation.JsonFormat;
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
@Entity(name = "promos")
public class PromoCommandEntity {


    @Id
    @Column(name = "promo_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID promoId;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "creationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date orderCreationTime;

    @PrePersist
    public void setDefaultStatusId() {
        if (orderCreationTime == null) {
            orderCreationTime = new Date();
        }
    }

}
