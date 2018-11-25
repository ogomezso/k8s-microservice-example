package com.datahack.k8sms.product.productApi.infrastructure.rest;

import com.datahack.k8sms.product.domain.exception.ProductDoesNotExistsException;
import com.datahack.k8sms.product.domain.exception.ProductInvalidException;
import com.datahack.k8sms.product.domain.model.Product;
import com.datahack.k8sms.product.productApi.application.ProductProcessor;
import com.datahack.k8sms.product.productApi.infrastructure.rest.model.ProductApiRequest;
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
public class ProductApi {


    private final ProductProcessor productProcessor;
    private final RestMapper productMapper;

    @Autowired
    public ProductApi(ProductProcessor productProcessor, RestMapper productMapper) {
        this.productProcessor = productProcessor;
        this.productMapper = productMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<Product> createProduct(
            @ApiParam("Request Body") @Valid @RequestBody ProductApiRequest request)  throws ProductInvalidException {

        Product domainObject = productMapper.request2Domain(request);

        return new ResponseEntity<>(productProcessor.createProduct(domainObject), HttpStatus.CREATED);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity modifyProduct(
            @ApiParam("Request Body") @Valid @RequestBody ProductApiRequest request) throws ProductInvalidException  {
        try {
            Product product = productMapper.request2Domain(request);
            Product modifiedProduct = productProcessor.modifyProduct(product);
            return new ResponseEntity<Product>(modifiedProduct, HttpStatus.OK);
        }catch (ProductDoesNotExistsException e) {
            return new ResponseEntity<String>("Product not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{productid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity getProduct(@PathVariable String productid) {
        try {
            Product product = productProcessor.getProduct(productid);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (ProductDoesNotExistsException e) {
            return new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{productid}", produces = {MediaType.TEXT_PLAIN_VALUE})
    ResponseEntity<String> deleteProduct(@PathVariable String productid) {
        if (productProcessor.deleteProduct(productid)) {
            return new ResponseEntity<>("Product "+productid+" deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
