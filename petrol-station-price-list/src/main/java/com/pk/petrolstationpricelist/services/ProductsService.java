package com.pk.petrolstationpricelist.services;

import com.pk.petrolstationpricelist.dtos.ProductDto;
import com.pk.petrolstationpricelist.entities.Products;
import com.pk.petrolstationpricelist.models.PriceList;
import com.pk.petrolstationpricelist.repositories.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public PriceList getPriceList() {
        return new PriceList(productsRepository.findAll());
    }

    public ProductDto updatePriceList(ProductDto productDto) {
        Products product = getModelMapper().map(productDto, Products.class);
        return getModelMapper().map(productsRepository.save(product), ProductDto.class);
    }

    private ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
