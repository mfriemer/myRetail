package com.myRetail.model

import org.springframework.data.annotation.Id

/**
 * Created by miker on 5/2/17.
 */
class ProductPrice {
    @Id
    String id

    Long productId

    Number value

    String currency

    Date effectiveDate = new Date()
}
