package com.myRetail.model.dto

import com.myRetail.model.ProductPrice

/**
 * Created by miker on 5/3/17.
 */
class ProductPriceDto {
    Number value

    String currency

    static ProductPriceDto fromProductPrice(ProductPrice productPrice) {
        new ProductPriceDto().with {
            value = productPrice.value
            currency = productPrice.currency
            it
        }
    }

    ProductPrice toProductPrice() {
        new ProductPrice().with {
            value = this.value
            currency = this.currency
            it
        }
    }
}
