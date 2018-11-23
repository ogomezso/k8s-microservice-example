package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.model.ProductPromo;
import com.datahack.promos.domain.model.ProductQuery;
import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.domain.model.PromoQuery;
import com.datahack.promos.promosApi.infrastructure.rest.model.ProductPromoApiRequest;
import com.datahack.promos.promosApi.infrastructure.rest.model.PromoApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.net.ConnectException;

import static io.fabric8.kubernetes.api.model.KubernetesKind.List;

@Component
public class PromoQueryBuilder {
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    private final RestTemplate restTemplate;


    @Value("${products.basepath}")
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
        response.getProductsQuery().clear();


        for (ProductPromo prod:promo.getProductsPromo()) {
            String getpath = promoBasepath+"/"+prod.getProductId().toString();

            try
            {
                ResponseEntity<ProductApiResponse> resp = restTemplate.getForEntity(getpath,ProductApiResponse.class);
                if(resp.getStatusCode() == HttpStatus.OK){
                    ProductQuery productQuery = podamFactory.manufacturePojo(ProductQuery.class);
                    response.getProductsQuery().add(productQuery);
                }
                else{
                    ProductQuery productQuery = podamFactory.manufacturePojo(ProductQuery.class);
                    productQuery.setProductId(prod.getProductId());
                    productQuery.setQuantity(prod.getQuantity());
                    productQuery.setProductPrice(prod.getUnitPrice());
                    response.getProductsQuery().add(productQuery);
                }
            }
            catch (ResourceAccessException e)
            {
                ProductQuery productQuery = podamFactory.manufacturePojo(ProductQuery.class);
                productQuery.setProductId(prod.getProductId());
                productQuery.setQuantity(prod.getQuantity());
                productQuery.setProductPrice(prod.getUnitPrice());
                response.getProductsQuery().add(productQuery);
                System.out.println("ConnectException caught. Downstream dependency is offline");
            }
            catch (Exception e)
            {
                System.out.println("Other Exception caught: " + e.getMessage());
            }


        }

        // TODO: asignar valores tras hacer una llamada REST
        //private List<ProductPromo> productsPromo;

        return response;
    }
}
