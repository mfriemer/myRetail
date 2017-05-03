package com.myRetail.config

import com.myRetail.client.ProductNameClient
import com.myRetail.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * Created by miker on 4/30/17.
 */

@Configuration
class MyRetailConfig {
    @Value('${client.resourceUri:http://redsky.target.com}')
    private String resourceUri

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build()
    }

    @Bean
    public ProductNameClient productNameClient() {
        new ProductNameClient(restTemplate(), resourceUri)
    }

    @Bean
    public ProductService productService() {
        new ProductService()
    }
}
