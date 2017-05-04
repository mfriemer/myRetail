package com.myRetail.dao

import com.myRetail.model.ProductPrice
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by miker on 5/2/17.
 */
interface ProductPriceRepository extends MongoRepository<ProductPrice, String> {
    List<ProductPrice> findAllByProductId(long productId)
}
