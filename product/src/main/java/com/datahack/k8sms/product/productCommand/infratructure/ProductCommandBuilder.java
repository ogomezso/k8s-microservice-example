package com.datahack.k8sms.product.productCommand.infratructure;

import com.datahack.k8sms.product.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Component
@Slf4j
public class ProductCommandBuilder {

    private final PodamFactory podamFactory = new PodamFactoryImpl();

    Product buildProduct(ProductCommandEntity entity, Product inprod){
        log.info("Building promo with entity {}",entity);
        log.info("Building promo with promo {}",inprod);
        Product prodnew = podamFactory.manufacturePojo(Product.class);

        prodnew.setId(entity.getId().toString());
        prodnew.setProductName(inprod.getProductName());
        prodnew.setVendId(entity.getVendId());
        prodnew.setQuantity(inprod.getQuantity());
        prodnew.setPrice(inprod.getPrice());
        prodnew.setExpirationDate(inprod.getExpirationDate());
        log.info("Returned product is: {}",prodnew);
        return prodnew;
    }

    ProductCommandEntity buildCommandEntity(Product prod){
        ProductCommandEntity entity = podamFactory.manufacturePojo(ProductCommandEntity.class);

        entity.setVendId(prod.getVendId());

        return entity;
    }

}
