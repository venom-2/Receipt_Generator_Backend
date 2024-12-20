package com.receipt.generator.repositories;

import com.receipt.generator.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
