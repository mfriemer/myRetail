package com.myRetail.service

import com.myRetail.client.ProductNameClient
import com.myRetail.dao.ProductPriceRepository
import com.myRetail.model.Product
import com.myRetail.model.ProductPrice
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
        // Get product name from REST client, product price from noSQL store
        List<ProductPrice> prices = productPriceRepository.findAllByProductId(id)

        new Product().with {
            productName = productNameClient.getProductName(id).name
            // get price with latest effective date
            if (prices) {
                productPrice = prices.sort { a, b -> -1 * (a.effectiveDate <=> b.effectiveDate) }.first()
            }
            it
        }
    }

    void saveProductPrice(ProductPrice productPrice) {
        productPriceRepository.save(productPrice)
    }
}
