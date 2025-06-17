package dev.hamidz.ecommerce.config;

import dev.hamidz.ecommerce.product.PurchaseRequest;
import dev.hamidz.ecommerce.product.PurchaseResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
