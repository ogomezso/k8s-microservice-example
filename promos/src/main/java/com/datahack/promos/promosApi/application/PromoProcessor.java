package com.datahack.promos.promosApi.application;

import com.datahack.promos.domain.model.Promo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PromoProcessor {

    private final PromoValidator promoValidator;
    private final CommandClient commandClient;

    @Autowired
    public PromoProcessor(PromoValidator promoValidator
            , CommandClient commandClient) {
        this.promoValidator = promoValidator;
        this.commandClient = commandClient;
    }

    public Promo createPromo(Promo promo) throws PromoInvalidException{

        Optional<Boolean> validated = Optional.ofNullable(promoValidator.validatePromo(promo));

        return validated.filter(v -> v.equals(true))
                .map(response ->  commandClient.createPromo(promo))
                .orElseThrow(() -> new PromoInvalidException("Promo is invalid."));

    }
}
