package com.datahack.k8sms.orders.ordersApi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("k8s Microservice Example Orders API")
                .description("This API manage Orders that will be consumed by the client ")
                .version("0.1.0-SNAPSHOT")
                .contact(new Contact("datahack school", "", ""))
                .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.datahack.k8sms.orders.ordersApi.infrastructure.rest"))
                .build()
                .apiInfo(apiInfo());
    }

  @Bean
  UiConfiguration uiConfig() {
    return new UiConfiguration("validationUrl");
  }
}
