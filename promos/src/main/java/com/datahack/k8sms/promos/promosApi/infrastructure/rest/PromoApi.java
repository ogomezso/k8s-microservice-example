package com.datahack.k8sms.promos.promosApi.infrastructure.rest;


import com.datahack.k8sms.promos.domain.exception.PromoDoesNotExistsException;
import com.datahack.k8sms.promos.promosApi.infrastructure.rest.model.PromoApiRequest;
import com.datahack.k8sms.promos.domain.exception.PromoInvalidException;
import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.domain.model.PromoQuery;
import com.datahack.k8sms.promos.promosApi.application.PromoProcessor;
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
public class PromoApi {

    private final PromoProcessor promoProcessor;
    private final RestMapper promoMapper;

    @Autowired
    public PromoApi(PromoProcessor promoProcessor
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

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<PromoQuery> modifyPromo(
            @ApiParam("Request Body") @Valid @RequestBody PromoApiRequest request) throws PromoInvalidException  {
        try {
            Promo promo = promoMapper.request2Domain(request);
            PromoQuery modifiedPromo = promoProcessor.modifyPromo(promo);
            return new ResponseEntity<>(modifiedPromo, HttpStatus.OK);
        }catch (PromoDoesNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping(path = "/{promoid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<PromoQuery> getPromo(@PathVariable String promoid) {
        try {
            PromoQuery promo = promoProcessor.getPromo(promoid);
            return new ResponseEntity<>(promo, HttpStatus.OK);
        }catch (PromoDoesNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{promoid}", produces = {MediaType.TEXT_PLAIN_VALUE})
    ResponseEntity<String> deletePromo(@PathVariable String promoid) {
        if (promoProcessor.deletePromo(promoid)) {
            return new ResponseEntity<>("Promo "+promoid+" deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
