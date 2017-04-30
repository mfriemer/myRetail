package com.myRetail.rest

import com.myRetail.model.Product
import com.myRetail.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created by miker on 4/30/17.
 */
@RestController
@RequestMapping(value = "/products")
class ProductController {
    @Autowired
    private ProductService productService

    @RequestMapping(value = "/{id}", method = GET, produces = "application/json")
    Product getProduct(@PathVariable( "id" ) Long id) {
        return productService.getProduct(id)
    }
}
