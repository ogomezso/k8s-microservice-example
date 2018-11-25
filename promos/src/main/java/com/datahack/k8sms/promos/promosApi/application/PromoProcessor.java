package com.datahack.k8sms.promos.promosApi.application;

import com.datahack.k8sms.promos.domain.exception.PromoDoesNotExistsException;
import com.datahack.k8sms.promos.domain.exception.PromoInvalidException;
import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.domain.model.PromoQuery;
import com.datahack.k8sms.promos.promosQuery.PromoQueryBuilder;
import com.datahack.k8sms.promos.promosQuery.QueryDas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class PromoProcessor {

    private final PromoValidator promoValidator;
    private final CommandClient commandClient;
    private final QueryClient queryClient;


    @Autowired
    public PromoProcessor(PromoValidator promoValidator
            , PromoQueryBuilder promoQueryBuilder
            , CommandClient commandClient
            , QueryClient queryClient) {
        this.promoValidator = promoValidator;

        this.commandClient = commandClient;
        this.queryClient = queryClient;
    }

    public Promo createPromo(Promo promo) throws PromoInvalidException {
        log.info("Creating Promo: {}",promo);
        Optional<Boolean> validated = Optional.ofNullable(promoValidator.validatePromo(promo));

        return validated.filter(v -> v.equals(true))
                .map(response ->  commandClient.createPromo(promo))
                .orElseThrow(() -> new PromoInvalidException("Promo is invalid."));

    }

    public PromoQuery modifyPromo(Promo promo) throws PromoDoesNotExistsException, PromoInvalidException {
        log.info("Modifying Promo: {}",promo);
        PromoQuery promoQuery = getPromo(promo.getId());

        if(! promoQuery.getSellerId().equals(promo.getSellerId())){
            throw new PromoInvalidException("Seller cannot be modified");
        }
        Optional<Boolean> validated = Optional.ofNullable(promoValidator.validatePromo(promo));
        return validated.filter(v -> v.equals(true))
                .map(response ->  queryClient.modifyPromo(promo))
                .orElseThrow(() -> new PromoInvalidException("Promo is invalid."));
    }

    public PromoQuery getPromo(String id) throws PromoDoesNotExistsException {
        log.info("Getting Promo: {}",id);
        return queryClient.getPromo(id);
    }

    public boolean deletePromo(String id)  {
        log.info("Deleting Promo: {}",id);
        return commandClient.deletePromo(id);
    }
}
