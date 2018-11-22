package com.datahack.promos.promosCommand;


import com.datahack.promos.domain.model.Promo;
import org.springframework.stereotype.Component;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Component
public class PromoBuilder {

    private final PodamFactory podamFactory = new PodamFactoryImpl();

    Promo buildPromo(PromoCommandEntity entity, Promo inpromo){
        Promo promonew = podamFactory.manufacturePojo(Promo.class);


        promonew.setId(entity.getPromoId().toString());
        promonew.setSellerId(entity.getSellerId());

        promonew.setTimeEnd(inpromo.getTimeEnd());
        promonew.setQuantity(inpromo.getQuantity());
        promonew.setDescription(inpromo.getDescription());
        promonew.setProductsPromo(inpromo.getProductsPromo());

        return promonew;
   }
}
