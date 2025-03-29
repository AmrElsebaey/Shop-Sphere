package com.elsebaey.shopsphere.repository;

import com.elsebaey.shopsphere.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
