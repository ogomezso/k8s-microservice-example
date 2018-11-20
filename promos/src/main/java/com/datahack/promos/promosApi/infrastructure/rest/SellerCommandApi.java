package com.datahack.promos.promosApi.infrastructure.rest;


import com.datahack.promos.promosApi.infrastructure.rest.application.SellerPromoProcessor;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "K8s Promos Sellers Command API")
@RequestMapping(path = "/promos")
@Controller
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*", maxAge = 3600)
public class SellerCommandApi {

    @Autowired
    public SellerCommandApi(SellerPromoProcessor sellerPromoProcessor){

    }
}
