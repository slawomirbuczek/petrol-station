package com.pk.petrolstationpricelist;

import com.pk.petrolstationpricelist.entities.Products;
import com.pk.petrolstationpricelist.enums.Product;
import com.pk.petrolstationpricelist.repositories.ProductsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
public class PetrolStationPriceListApplication {

    private final ProductsRepository productsRepository;

    public PetrolStationPriceListApplication(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public static void main(java.lang.String[] args) {
        SpringApplication.run(PetrolStationPriceListApplication.class, args);
    }

    @PostConstruct
    public void setProducts() {
        productsRepository.save(new Products(Product.E95, 5.79f));
        productsRepository.save(new Products(Product.E98, 5.99f));
        productsRepository.save(new Products(Product.DIESEL, 5.59f));
        productsRepository.save(new Products(Product.LPG, 2.89f));
        productsRepository.save(new Products(Product.WASHING_STANDARD, 19.99f));
        productsRepository.save(new Products(Product.WASHING_WITH_WAXING, 34.99f));
    }
}
