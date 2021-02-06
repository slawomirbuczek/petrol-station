package com.pk.petrolstationpricelist.controllers;

import com.pk.petrolstationpricelist.dtos.ProductDto;
import com.pk.petrolstationpricelist.models.PriceList;
import com.pk.petrolstationpricelist.services.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricelist")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<PriceList> getPriceList() {
        return ResponseEntity.ok(productsService.getPriceList());
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productsService.updatePriceList(productDto));
    }

}
