package com.myRetail.service

import com.myRetail.client.ProductNameClient
import com.myRetail.dao.ProductPriceRepository
import com.myRetail.model.Product
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by miker on 4/30/17.
 */
class ProductService {
    @Autowired
    ProductPriceRepository productPriceRepository

    @Autowired
    ProductNameClient productNameClient

    Product getProduct(Long id) {
        // Get product name from resource

        // Get product price from noSQL store
        new Product().with {
            productName = productNameClient.getProductName(id)
            productPrice = productPriceRepository.findByProductId(id)
            it
        }
    }
}
