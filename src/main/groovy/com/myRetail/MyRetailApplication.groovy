package com.myRetail

import com.myRetail.dao.ProductPriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MyRetailApplication  {
	@Autowired
	ProductPriceRepository priceRepository

	static void main(String[] args) {
		SpringApplication.run MyRetailApplication, args
	}

}
