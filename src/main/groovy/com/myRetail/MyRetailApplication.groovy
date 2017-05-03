package com.myRetail

import com.myRetail.dao.ProductPriceRepository
import com.myRetail.model.ProductPrice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MyRetailApplication implements CommandLineRunner {
	@Autowired
	ProductPriceRepository priceRepository

	static void main(String[] args) {
		SpringApplication.run MyRetailApplication, args
	}

	@Override
	public void run(String... args) throws Exception {
        priceRepository.deleteAll()

		//init product prices
		ProductPrice price = new ProductPrice().with {
			productId = 13860428
			price = 19.99
            currency = 'USD'
			it
		}
		priceRepository.save(price)
	}
}
