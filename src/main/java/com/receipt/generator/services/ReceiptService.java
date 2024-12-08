package com.receipt.generator.services;

import com.receipt.generator.dao.ReceiptDAO;
import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    ReceiptDAO receiptDAO;

    public ResponseEntity<?> saveReceipt(Receipt receipt) {
        Response res  = receiptDAO.saveReceipt(receipt);
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<?> fetchReceipt(String userEmail) {
        List<Receipt> receiptList = receiptDAO.fetchReceipt(userEmail);
        return ResponseEntity.ok(receiptList);
    }

    public ResponseEntity<?> deleteReceipt(String billNumber, String email) {
        Response res = receiptDAO.deleteReceipt(billNumber, email);
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<?> fetchCustomerReceipt(String customerPhone, String email) {
        List<Receipt> receiptList = receiptDAO.fetchCustomerReceipt(customerPhone, email);
        return ResponseEntity.ok(receiptList);
    }
}
