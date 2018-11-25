package com.datahack.k8sms.promos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PromoConfig {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
