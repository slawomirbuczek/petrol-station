package com.pk.petrolstationpricelist.models;

import com.pk.petrolstationpricelist.entities.Products;

import java.util.List;

public class PriceList {

    private List<Products> list;

    public PriceList() {
    }

    public PriceList(List<Products> list) {
        this.list = list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    public List<Products> getList() {
        return list;
    }
}
