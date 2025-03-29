package com.elsebaey.shopsphere.controll;

import com.elsebaey.shopsphere.dto.ProductRequest;
import com.elsebaey.shopsphere.dto.ProductResponse;
import com.elsebaey.shopsphere.model.Product;
import com.elsebaey.shopsphere.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return service.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductResponse> getAllProducts() {
        return service.getAllProducts();
    }
}
