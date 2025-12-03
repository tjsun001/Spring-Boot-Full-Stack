package com.thurman.porfolio.springbootfullstack.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record NewProductRequest(
        @NotBlank
        @Size(min = 2, max = 50)
        String name,

        @Size(max = 500,
                min = 1,
                message = "Desc must be >1 <=500 characters")
        String description,

        @NotNull(message = "Price is required")
        @DecimalMin(value ="0.1",
                message = "Price must be > 0")
        BigDecimal price,

        @NotBlank @Size(
                min = 1,
                max = 500,
                message = "ImageUrl must be >1 <=10 characters")
        String imageUrl,

        @NotNull(message = " ")
        @Min(value  = 1,
            message = "Stock Level must be >=1")
        Integer stockLevel
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
    public BigDecimal price() {
        return price;
    }

    @Override
    public Integer stockLevel() {
        return stockLevel;
    }

    @Override
    public String imageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewProductRequest that = (NewProductRequest) o;
        return Objects.equals(name(), that.name()) && Objects.equals(imageUrl(), that.imageUrl()) && Objects.equals(price(), that.price()) && Objects.equals(description(), that.description()) && Objects.equals(stockLevel(), that.stockLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name(), description(), price(), stockLevel(), imageUrl());
    }
}

