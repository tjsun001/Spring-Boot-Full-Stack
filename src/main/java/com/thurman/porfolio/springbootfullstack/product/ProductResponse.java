package com.thurman.porfolio.springbootfullstack.product;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record ProductResponse (
        UUID id,
    String name,
    String description,
    BigDecimal price
    ,String imageUrl
    ,Integer stockLevel
) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(id(), that.id()) && Objects.equals(name(), that.name()) && Objects.equals(imageUrl(), that.imageUrl()) && Objects.equals(price(), that.price()) && Objects.equals(description(), that.description()) && Objects.equals(stockLevel(), that.stockLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id(), name(), description(), price(), imageUrl(), stockLevel());
    }
}

