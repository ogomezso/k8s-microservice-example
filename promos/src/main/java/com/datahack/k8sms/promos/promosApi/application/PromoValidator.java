package com.datahack.k8sms.promos.promosApi.application;


import com.datahack.k8sms.promos.domain.model.ProductPromo;
import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.promosQuery.ProductApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class PromoValidator {

    private final RestTemplate restTemplate;

    @Value("${products.basepath}")
    private String productsBasePath;

    @Autowired
    public PromoValidator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    Boolean validatePromo(Promo promo){
        Boolean isPromoValid = true;
        //To validate a promo:
        //* All products should exist.
        //* Product quantity should be enough to fulfill promo (for now)

        //TODO Implment
        //LLamar a productquery

        for(ProductPromo prod : promo.getProductsPromo()){
            String url = productsBasePath + "/" + prod.getProductId();
            try {

                ResponseEntity<ProductApiResponse> resp = restTemplate.getForEntity(url, ProductApiResponse.class);
                if(resp.getStatusCode() == HttpStatus.OK) {
                    ProductApiResponse apiresponse = resp.getBody();
                    if(apiresponse.getQuantity() >= promo.getQuantity()*prod.getQuantity())
                    {
                        log.info("Product {} is OK to include in promo",prod);
                    }
                    else
                    {
                        log.error("Product {} not OK to be included", prod);
                        isPromoValid = false;
                        break;
                    }
                }
                else{
                    //Product not found, we stop
                    isPromoValid = false;
                    break;
                }
            } catch (ResourceAccessException e){
                log.error("Connection problem to {}",url);
            }
        }

        return isPromoValid;
    }
}
