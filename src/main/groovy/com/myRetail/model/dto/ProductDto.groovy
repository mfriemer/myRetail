package com.myRetail.model.dto

import com.myRetail.model.Product

/**
 * Created by miker on 5/3/17.
 */
class ProductDto {
    String productName

    ProductPriceDto productPrice

    static ProductDto fromProduct(Product product) {
        new ProductDto().with {
            productName = product.productName
            productPrice = ProductPriceDto.fromProductPrice(product.productPrice)
            it
        }
    }
}
