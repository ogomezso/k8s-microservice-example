package com.datahack.k8sms.promos.promosCommand;


import com.datahack.k8sms.promos.domain.model.Promo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Component
@Slf4j
public class PromoBuilder {

    private final PodamFactory podamFactory = new PodamFactoryImpl();

    Promo buildPromo(PromoCommandEntity entity, Promo inpromo){
        log.info("Building promo with entity {}",entity);
        log.info("Building promo with promo {}",inpromo);
        Promo promonew = podamFactory.manufacturePojo(Promo.class);

        promonew.setId(entity.getPromoId().toString());
        promonew.setSellerId(entity.getSellerId());

        promonew.setTimeEnd(inpromo.getTimeEnd());
        promonew.setQuantity(inpromo.getQuantity());
        promonew.setDescription(inpromo.getDescription());
        promonew.setProductsPromo(inpromo.getProductsPromo());
        log.info("Returned promo is: {}",promonew);
        return promonew;
   }
}
