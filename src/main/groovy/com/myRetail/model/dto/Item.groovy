package com.myRetail.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * Created by miker on 4/30/17.
 */
class Item {
    @JsonProperty("product_description")
    ProductDescription productDescription
}
