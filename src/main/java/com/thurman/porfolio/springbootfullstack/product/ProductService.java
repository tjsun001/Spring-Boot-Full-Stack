package com.thurman.porfolio.springbootfullstack.product;

import com.thurman.porfolio.springbootfullstack.exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID uuid) {
        return productRepository.findById(uuid)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "product " + uuid + " is not not found")
                );
    }
}
