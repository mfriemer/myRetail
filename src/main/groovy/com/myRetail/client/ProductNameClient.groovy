package com.myRetail.client

import com.myRetail.model.ProductName
import com.myRetail.model.dto.RedskyEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

/**
 * Created by miker on 4/30/17.
 */
class ProductNameClient {
    private RestTemplate restTemplate
    private String resourceUri

    public ProductNameClient(RestTemplate template, String resourceUri) {
        this.restTemplate = template
        this.resourceUri = resourceUri
    }

    //TODO: handle 404 errors cleanly, throw 404 upstream
    public ProductName getProductName(Long id) {
        ResponseEntity<RedskyEntity> responseEntity = restTemplate.getForEntity(resourceUri + "/v2/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", RedskyEntity.class, id)
       ProductName productName = new ProductName().with {
            productId = id
            productName = responseEntity.body.product.item.productDescription.title
            it
        }

        productName
    }

}
