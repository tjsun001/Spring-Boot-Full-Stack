package com.thurman.porfolio.springbootfullstack.product;

import com.thurman.porfolio.springbootfullstack.exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        return   productRepository.findAll()
                .stream()
                .map(mapToResponse())
                .toList();
    }

    public ProductResponse getProductById(UUID uuid) {
        return productRepository.findById(uuid)
                .map(mapToResponse())
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "product " + uuid + " is not not found")
                );
    }

    private Function<Product, ProductResponse> mapToResponse () {
        return p1 -> new ProductResponse(
                p1.getId()
                ,p1.getName()
                ,p1.getDescription()
                ,p1.getPrice()
                ,p1.getImageUrl()
                ,p1.getStockLevel()
        );
    }

    public void deleteProductById(UUID id) {
        boolean exists = productRepository.existsById(id);
        if(!exists) {
            throw new ResourceNotFound("product " + id + " is not not found"
            );
        }
        productRepository.deleteById(id);
    }

    public UUID saveNewProduct(NewProductRequest productRequest) {
        UUID id = UUID.randomUUID();
        Product product = new Product(
                id
                , productRequest.name()
                , productRequest.description()
                ,productRequest.price()
                ,productRequest.imageUrl()
                , productRequest.stockLevel()
        );
        return productRepository.save(product).getId();
    }
 public UUID updateProduct(UUID uuid,UpdateProductRequest productRequest) {
        Product product = productRepository.findById(uuid)
             .orElseThrow(() ->
                     new ResourceNotFound(
                             "product " + uuid + " is not not found")
             );

        if (productRequest.name() != null && !product.getName().equals(productRequest.name())){
            product.setName(productRequest.name());
         }
        if ((productRequest.description() != null) && !(product.getDescription().equals(productRequest.description()))){
            product.setDescription(productRequest.description());
             }
        if ((productRequest.imageUrl() != null) && !(product.getImageUrl().equals(productRequest.imageUrl()))){
            product.setImageUrl(productRequest.imageUrl());
            }
        if ((productRequest.price() != null) && !(product.getPrice().equals(productRequest.price()))){
                    product.setPrice(productRequest.price());
            }
        if ((productRequest.stockLevel() != null) && !(product.getStockLevel().equals(productRequest.stockLevel()))){
                    product.setStockLevel(productRequest.stockLevel());
            }
        if ((productRequest.isPublished() != null) && !(product.getIsPublished().equals(productRequest.isPublished()))){
                    product.setIsPublished(productRequest.isPublished());
            }
        productRepository.save(product);
        return product.getId();
    }
}
