package com.receipt.generator.services;

import com.receipt.generator.dao.ReceiptDAO;
import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    @Autowired
    ReceiptDAO receiptDAO;

    public ResponseEntity<?> saveReceipt(Receipt receipt) {
        Response res  = receiptDAO.saveReceipt(receipt);
        return ResponseEntity.ok(res);
    }
}
