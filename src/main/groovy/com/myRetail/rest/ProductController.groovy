package com.myRetail.rest

import com.myRetail.model.ProductPrice
import com.myRetail.model.dto.ProductDto
import com.myRetail.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.PUT

/**
 * Created by miker on 4/30/17.
 */
@RestController
@RequestMapping(value = "/products")
class ProductController {
    @Autowired
    private ProductService productService

    @RequestMapping(value = "/{id}", method = GET, produces = "application/json")
    ResponseEntity<ProductDto> getProduct(@PathVariable( "id" ) Long id) {
        try {
            return new ResponseEntity(ProductDto.fromProduct(productService.getProduct(id)), HttpStatus.OK)
        }
        catch (HttpClientErrorException e) {
            return new ResponseEntity(e.statusCode)
        }
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateProductPrice(@PathVariable( "id" ) Long id, @RequestBody ProductDto productDto) {
        ProductPrice productPrice = productDto.productPrice.toProductPrice()
        productPrice.productId = id
        productService.saveProductPrice(productPrice)
    }
}
