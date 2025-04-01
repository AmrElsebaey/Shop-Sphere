package com.elsebaey.shopsphere.order.dto;

import java.math.BigDecimal;

public record OrderRequest(
        String id,
        String orderNumber,
        String skuCode,
        Integer quantity,
        BigDecimal price
) {
}
