package com.thurman.porfolio.springbootfullstack.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record UpdateProductRequest(
        @Size(min = 2, max = 50)
        String name,

        @Size(max = 500, min = 1, message = "Desc must be >1 <=500 characters")
        String description,

        @DecimalMin(value ="1.1",
                message = "Price must be > 0")
        BigDecimal price,
        String imageUrl,
        Integer stockLevel,
        Boolean isPublished
) {
    @Override
    public String name() {
        return name;
    }

    @Override

    public String description() {
        return description;
    }

    @Override
    @DecimalMin(value ="1.1",
            message = "Price must be > 0")
    public BigDecimal price() {
        return price;
    }

    @Override
    @Min(value  = 1,
            message = "Stock Level must be >=1")
    public Integer stockLevel() {
        return stockLevel;
    }

    @Override
    @Size(
            min = 1,
            max = 500,
            message = "ImageUrl must be >1 <=10 characters")
    public String imageUrl() {
        return imageUrl;
    }
    @Override
    public Boolean isPublished() {
        return isPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UpdateProductRequest that = (UpdateProductRequest) o;
        return Objects.equals(name(), that.name()) &&
                Objects.equals(imageUrl(), that.imageUrl()) &&
                Objects.equals(price(), that.price()) &&
                Objects.equals(description(), that.description())
                && Objects.equals(stockLevel(), that.stockLevel())
                && Objects.equals(isPublished(), that.isPublished());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name(),
                description(),
                price(),
                stockLevel(),
                imageUrl(),
                isPublished()
        );
    }
}

