package com.pk.petrolstationpricelist;

import com.pk.petrolstationpricelist.repositories.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PetrolStationProductsApplicationTests {

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    void shouldAddDefaultDataWhenContextLoaded() {
        assertThat(productsRepository.findAll()).hasSize(6);
    }

}
