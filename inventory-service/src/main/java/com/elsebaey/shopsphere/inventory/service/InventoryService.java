package com.elsebaey.shopsphere.inventory.service;

import com.elsebaey.shopsphere.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;
    

    public boolean isInStock(String skuCode, Integer quantity) {
        return repository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
