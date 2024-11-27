package com.receipt.generator.repositories;

import com.receipt.generator.entities.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {
    boolean existsByBillNumber(String billNumber);

    List<Receipt> findAllByUser(String userId);

    void deleteByBillNumber(String billNumber);

    List<Receipt> findAllByCustomerPhone(String customerPhone);
}
