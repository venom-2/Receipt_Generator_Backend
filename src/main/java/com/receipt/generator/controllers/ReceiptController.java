package com.receipt.generator.controllers;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @PostMapping("/save")
    public ResponseEntity<?> saveReceipt(@RequestBody Receipt receipt) {
        return receiptService.saveReceipt(receipt);
    }
}
