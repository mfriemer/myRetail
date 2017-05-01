package com.myRetail

import com.myRetail.client.ProductNameClient
import com.myRetail.model.ProductName
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by mriemer on 5/1/17.
 */
class ProductNameClientSpec extends Specification {
    RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory())

    ProductNameClient productNameClient = new ProductNameClient(restTemplate, 'http://redsky.target.com')

    //TODO: ignore?  or way to mock http request
    def "test redsky endpoint" () {
        when:
        ProductName productName = productNameClient.getProductName(13860428)

        then:
        productName.productName.contains('The Big Lebowski')
    }

}
