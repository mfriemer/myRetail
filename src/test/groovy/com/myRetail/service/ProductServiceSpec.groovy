package com.myRetail.service

import com.myRetail.client.ProductNameClient
import com.myRetail.dao.ProductPriceRepository
import com.myRetail.model.Product
import com.myRetail.model.ProductName
import com.myRetail.model.ProductPrice
import spock.lang.Specification

/**
 * Created by miker on 5/3/17.
 */
class ProductServiceSpec extends Specification {
    ProductPriceRepository productPriceRepository = Mock(ProductPriceRepository)
    ProductNameClient productNameClient = Mock(ProductNameClient)
    ProductService productService = new ProductService(productPriceRepository: productPriceRepository,
            productNameClient: productNameClient)

    def "ProductService returns the product w/ latest product price"() {
        given: 'a product w/ id'
        long productId = 123

        and: 'multiple prices exist for product'
        ProductPrice price1 = new ProductPrice(value: 12.99, effectiveDate: new Date(2017, 01, 01))
        ProductPrice price2 = new ProductPrice(value: 13.99, effectiveDate: new Date(2017, 04, 01))

        when:
        Product p = productService.getProduct(productId)

        then:
        1 * productNameClient.getProductName(productId) >> Mock(ProductName)
        1 * productPriceRepository.findAllByProductId(productId) >> [price1, price2]
        p.productPrice.value == 13.99
    }

    def "ProductService returns the product when no price found"() {
        given: 'a product w/ id'
        long productId = 123

        when:
        Product p = productService.getProduct(productId)

        then:
        1 * productNameClient.getProductName(productId) >> Mock(ProductName)
        1 * productPriceRepository.findAllByProductId(productId) >> []
        p.productPrice == null
    }
}
