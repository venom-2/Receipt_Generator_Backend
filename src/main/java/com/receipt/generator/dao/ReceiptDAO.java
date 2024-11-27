package com.receipt.generator.dao;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import com.receipt.generator.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptDAO {

    @Autowired
    ReceiptRepository receiptRepository;

    public Response saveReceipt(Receipt receipt) {
        if(receiptRepository.existsByBillNumber(receipt.getBillNumber()))
            return new Response(HttpStatus.CONFLICT.value(), "Receipt with this bill number already exists!");
        try {
            receiptRepository.save(receipt);
            return new Response(HttpStatus.ACCEPTED.value(), "Receipt saved!");
        } catch (Exception ex) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed to save Receipt!");
        }
    }
}
