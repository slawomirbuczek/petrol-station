package com.pk.petrolstationpricelist.services;

import com.pk.petrolstationpricelist.dtos.ProductDto;
import com.pk.petrolstationpricelist.entities.Products;
import com.pk.petrolstationpricelist.models.PriceList;
import com.pk.petrolstationpricelist.repositories.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    private final Logger logger = LoggerFactory.getLogger(ProductsService.class);
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public PriceList getPriceList() {
        logger.trace("Returning price list - service");
        return new PriceList(productsRepository.findAll());
    }

    public ProductDto updateProduct(ProductDto productDto) {
        ModelMapper modelMapper = new ModelMapper();
        Products product = modelMapper.map(productDto, Products.class);
        logger.trace("Updating product - service");
        return modelMapper.map(productsRepository.save(product), ProductDto.class);
    }

}
