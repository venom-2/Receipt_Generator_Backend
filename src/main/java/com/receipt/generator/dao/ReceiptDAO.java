package com.receipt.generator.dao;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import com.receipt.generator.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Receipt> fetchReceipt(String userEmail) {
        return receiptRepository.findAllByUser(userEmail);
    }

    public Response deleteReceipt(String billNumber) {
        if(!receiptRepository.existsByBillNumber(billNumber))
            return new Response(HttpStatus.NO_CONTENT.value(), "No record found!");
        receiptRepository.deleteByBillNumber(billNumber);
        return new Response(HttpStatus.ACCEPTED.value(), "Deleted Receipt with bill number "+ billNumber);
    }

    public List<Receipt> fetchCustomerReceipt(String customerPhone) {
        return receiptRepository.findAllByCustomerPhone(customerPhone);
    }
}
