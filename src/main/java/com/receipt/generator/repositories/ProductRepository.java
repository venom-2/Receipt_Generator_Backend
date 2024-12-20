package com.receipt.generator.repositories;

import com.receipt.generator.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByUser(String email);
}
