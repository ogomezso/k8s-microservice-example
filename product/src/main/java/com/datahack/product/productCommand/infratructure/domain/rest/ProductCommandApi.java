package com.datahack.product.productCommand.infratructure.domain.rest;

import com.datahack.product.domain.model.ProductCommand;
import com.datahack.product.productApi.application.ProductOrderProcessor;
import com.datahack.product.productCommand.infratructure.domain.rest.model.ProductApiRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "K8s Orders Product Command API")
@RequestMapping(path = "/product")
@Controller
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*", maxAge = 3600)
public class ProductCommandApi {


    private final ProductOrderProcessor productOrderProcessor;
    private final RestMapper mapper;

    @Autowired
    public ProductCommandApi(ProductOrderProcessor productOrderProcessor, RestMapper mapper) {
        this.productOrderProcessor = productOrderProcessor;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<ProductCommand> createVisit(
            @ApiParam("Request Body") @Valid @RequestBody ProductApiRequest request)  {

        ProductCommand domainObject = mapper.request2Domain(request);

        return new ResponseEntity<>(productOrderProcessor.processClientOrder(domainObject), HttpStatus.CREATED);

    }

}
