package com.receipt.generator.dao;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import com.receipt.generator.entities.User;
import com.receipt.generator.repositories.ReceiptRepository;
import com.receipt.generator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReceiptDAO {

    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    UserRepository userRepository;

    public Response saveReceipt(Receipt receipt) {
        if(receiptRepository.existsByBillNumberAndUser(receipt.getBillNumber(), receipt.getUser()))
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

    public Response deleteReceipt(String billNumber, String email) {
        if(!receiptRepository.existsByBillNumber(billNumber))
            return new Response(HttpStatus.NO_CONTENT.value(), "No record found!");
        receiptRepository.deleteByBillNumberAndUser(billNumber, email);
        return new Response(HttpStatus.ACCEPTED.value(), "Deleted Receipt with bill number "+ billNumber);
    }

    public List<Receipt> fetchCustomerReceipt(String customerPhone, String email) {

        // Fetch all receipts that match the customer phone number and are associated with this user
        List<Receipt> receipts = receiptRepository.findAllByUser(email);

        // Filter receipts to include only those with the matching customer phone number

        return receipts.stream()
                .filter(receipt -> customerPhone.equals(receipt.getCustomerPhone()))
                .collect(Collectors.toList());
    }
}
