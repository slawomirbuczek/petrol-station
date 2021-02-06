package com.pk.petrolstationpricelist.entities;

import com.pk.petrolstationpricelist.enums.Product;

import javax.persistence.*;

@Entity
@Table(name = "price_list")
public class Products {

    @Id
    @Enumerated(EnumType.STRING)
    private Product product;

    private float price;

    public Products() {
    }

    public Products(Product product, float price) {
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
