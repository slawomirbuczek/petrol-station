package com.pk.petrolstationpricelist.repositories;

import com.pk.petrolstationpricelist.entities.Products;
import com.pk.petrolstationpricelist.enums.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Product> {

}
