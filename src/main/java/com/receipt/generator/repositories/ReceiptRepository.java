package com.receipt.generator.repositories;

import com.receipt.generator.entities.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {
    boolean existsByBillNumber(String billNumber);
}
