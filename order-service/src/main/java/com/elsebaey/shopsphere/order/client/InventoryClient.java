package com.elsebaey.shopsphere.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "isInStock")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    default boolean isInStock(String skuCode, Integer quantity, Throwable throwable) {
        System.out.println("Inventory service is not available");
        return false;
    }
}
