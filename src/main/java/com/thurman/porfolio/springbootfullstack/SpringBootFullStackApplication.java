package com.thurman.porfolio.springbootfullstack;

import com.thurman.porfolio.springbootfullstack.product.Product;
import com.thurman.porfolio.springbootfullstack.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
@EntityScan("com.thurman.porfolio.springbootfullstack.product")
public class SpringBootFullStackApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootFullStackApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            ProductRepository productRepository) {
        return args -> {
            Product product = new Product();
            product.setName("Macbook Pro");
            product.setDescription("Macbook Pro M4");
            product.setPrice(new BigDecimal(3000));
            product.setStockLevel(100);
            product.setImageUrl("https://www.google.com");
            product.setId(UUID.fromString(
                    "0B1C82C8-F003-415D-AFA6-A41FEC41A62E")
            );
            productRepository.save(product);
        };
    }

}
