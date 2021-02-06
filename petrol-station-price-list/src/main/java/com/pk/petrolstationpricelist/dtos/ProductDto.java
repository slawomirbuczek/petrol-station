package com.pk.petrolstationpricelist.dtos;

import com.pk.petrolstationpricelist.enums.Product;

public class ProductDto {

    private Product product;

    private float price;

    public ProductDto() {
    }

    public ProductDto(Product product, float price) {
        this.product = product;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public float getPrice() {
        return price;
    }

    public void setProduct(Product name) {
        this.product = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
