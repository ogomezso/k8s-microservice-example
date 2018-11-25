package com.datahack.k8sms.orders.ordersApi.infrastructure.rest;

import com.datahack.k8sms.orders.domain.exception.OrderDoesNotExistsException;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import com.datahack.k8sms.orders.ordersApi.application.ClientOrderProcessor;
import com.datahack.k8sms.orders.domain.exception.PromoNotAvailableException;
import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.ordersApi.infrastructure.rest.model.ClientApiRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "K8s Orders Client Command API")
@RequestMapping(path = "/orders")
@Controller
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*", maxAge = 3600)
public class ClientCommandApi {

    private final ClientOrderProcessor clientOrderProcessor;
    private final RestMapper mapper;

    @Autowired
    public ClientCommandApi(ClientOrderProcessor clientOrderProcessor, RestMapper mapper) {
        this.clientOrderProcessor = clientOrderProcessor;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<OrderCommand> createOrder(
            @ApiParam("Request Body") @Valid @RequestBody ClientApiRequest request) throws PromoNotAvailableException {

        OrderCommand domainObject = mapper.request2Domain(request);

        return new ResponseEntity<>(clientOrderProcessor.processClientOrder(domainObject), HttpStatus.CREATED);

    }

//    ORDER CANNOT BE MODIFIED (FOR NOW)
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    ResponseEntity<OrderCommand> modifyOrder(
//            @ApiParam("Request Body") @Valid @RequestBody ClientApiRequest request) throws PromoInvalidException  {
//        try {
//            OrderCommand domainObject = mapper.request2Domain(request);
//            OrderCommand modifiedCommand = clientOrderProcessor.modifyOrder(domainObject);
//            return new ResponseEntity<>(modifiedCommand, HttpStatus.OK);
//        }catch (OrderDoesNotExistsException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//    }

    @GetMapping(path = "/{orderid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<OrderQuery> getPromo(@PathVariable String orderid) {
        try {
            OrderQuery orderQuery = clientOrderProcessor.getOrder(orderid);
            return new ResponseEntity<>(orderQuery, HttpStatus.OK);
        }catch (OrderDoesNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{orderid}", produces = {MediaType.TEXT_PLAIN_VALUE})
    ResponseEntity<String> deletePromo(@PathVariable String orderid) {
        if (clientOrderProcessor.deleteOrder(orderid)) {
            return new ResponseEntity<>("Order "+orderid+" deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
