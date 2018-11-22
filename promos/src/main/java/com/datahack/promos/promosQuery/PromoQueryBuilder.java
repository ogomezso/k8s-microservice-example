package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.domain.model.PromoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Component
public class PromoQueryBuilder {
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    private final RestTemplate restTemplate;

    @Value("${promos.basepath}")
    private String promoBasepath;

    @Autowired
    public PromoQueryBuilder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    PromoQuery build(Promo promo) {
        PromoQuery response = podamFactory.manufacturePojo(PromoQuery.class);

        response.setId(promo.getId());
        response.setSellerId(promo.getSellerId());
        response.setTimeEnd(promo.getTimeEnd());
        response.setQuantity(promo.getQuantity());
        response.setDescription(promo.getDescription());




        // TODO: asignar valores tras hacer una llamada REST
        //private List<ProductPromo> productsPromo;

        return response;
    }
}
