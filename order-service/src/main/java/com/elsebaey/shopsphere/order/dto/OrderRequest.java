package com.elsebaey.shopsphere.order.dto;

import java.math.BigDecimal;

public record OrderRequest(
        String id,
        String orderNumber,
        String skuCode,
        Integer quantity,
        BigDecimal price,
        UserDetails userDetails
) {
    public record UserDetails(
            String firstName,
            String lastName,
            String email
    ) {}
}
