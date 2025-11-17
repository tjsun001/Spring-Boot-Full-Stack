package com.thurman.porfolio.springbootfullstack.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(
        name = "product"
)
public class Product {
    @PrePersist
    public void prePersist() {
        if(this.id==null) {
            this.id = UUID.randomUUID();
        }
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }

    @Id
    private UUID id;

    @Column(nullable = false,length = 50)
    private String name;

    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 50)
    private String imageUrl;

    @Column(nullable = false)
    private Integer stockLevel;

    @Column(nullable = false,updatable = false)
    private Instant createdAt;

    @Column(nullable = false,updatable = false)
    private Instant updatedAt;

    private Instant deletedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getStockLevel() == product.getStockLevel() && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getImageUrl(), product.getImageUrl()) && Objects.equals(getCreatedAt(), product.getCreatedAt()) && Objects.equals(getUpdatedAt(), product.getUpdatedAt()) && Objects.equals(getDeletedAt(), product.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getImageUrl(), getStockLevel(), getCreatedAt(), getUpdatedAt(), getDeletedAt());
    }
}
