package com.elsebaey.shopsphere.service;

import com.elsebaey.shopsphere.dto.ProductRequest;
import com.elsebaey.shopsphere.dto.ProductResponse;
import com.elsebaey.shopsphere.model.Product;
import com.elsebaey.shopsphere.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        repository.save(product);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                        )
                )
                .toList();
    }
}
