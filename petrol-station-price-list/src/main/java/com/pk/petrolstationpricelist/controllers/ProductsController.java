package com.pk.petrolstationpricelist.controllers;

import com.pk.petrolstationpricelist.dtos.ProductDto;
import com.pk.petrolstationpricelist.models.PriceList;
import com.pk.petrolstationpricelist.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricelist")
public class ProductsController {

    private final Logger logger = LoggerFactory.getLogger(ProductsController.class);
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<PriceList> getPriceList() {
        logger.trace("Get price list method called");
        return ResponseEntity.ok(productsService.getPriceList());
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        logger.trace("Update product method called");
        return ResponseEntity.ok(productsService.updateProduct(productDto));
    }

}
