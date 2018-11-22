package com.datahack.promos.promosApi.infrastructure.rest;


import com.datahack.promos.domain.exception.PromoInvalidException;
import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.promosApi.application.PromoProcessor;
import com.datahack.promos.promosApi.infrastructure.rest.model.PromoApiRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "K8s Promos Sellers Command API")
@RequestMapping(path = "/promos")
@Controller
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*", maxAge = 3600)
public class PromoCommandApi {

    private final PromoProcessor promoProcessor;
    private final RestMapper promoMapper;

    @Autowired
    public PromoCommandApi(PromoProcessor promoProcessor
                    , RestMapper promoMapper){
        this.promoProcessor = promoProcessor;
        this.promoMapper = promoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<Promo> createPromo(
            @ApiParam("Request Body") @Valid @RequestBody PromoApiRequest request) throws PromoInvalidException {

        Promo promo = promoMapper.request2Domain(request);

        return new ResponseEntity<>(promoProcessor.createPromo(promo), HttpStatus.CREATED);
    }
}
