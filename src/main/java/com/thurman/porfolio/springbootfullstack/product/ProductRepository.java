package com.thurman.porfolio.springbootfullstack.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository
        extends JpaRepository<Product, UUID> {
    Product getProductsById(UUID id);

    Product findProductById(UUID id);
}
