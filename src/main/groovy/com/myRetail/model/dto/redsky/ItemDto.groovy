package com.myRetail.model.dto.redsky

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by miker on 4/30/17.
 */
class ItemDto {
    @JsonProperty("product_description")
    ProductDescriptionDto productDescription
}
