package com.receipt.generator.dao;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.entities.Response;
import com.receipt.generator.exceptions.DuplicateResource;
import com.receipt.generator.exceptions.ResourceNotFound;
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

    public Response saveReceipt(Receipt receipt) throws DuplicateResource {
        if(receiptRepository.existsByBillNumberAndUser(receipt.getBillNumber(), receipt.getUser()))
            throw new DuplicateResource("Receipt with this bill number already exists!");
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

    public Response deleteReceipt(String billNumber, String email) throws ResourceNotFound {
        if(!receiptRepository.existsByBillNumber(billNumber))
            throw new ResourceNotFound("No record found!");
        receiptRepository.deleteByBillNumberAndUser(billNumber, email);
        return new Response(HttpStatus.ACCEPTED.value(), "Deleted Receipt with bill number "+ billNumber);
    }

    public List<Receipt> fetchCustomerReceipt(String customerPhone, String email) {

        // Fetch all receipts that match the customer phone number and are associated with this user
        List<Receipt> receipts = receiptRepository.findAllByUser(email);

        return receipts.stream()
                .filter(receipt -> customerPhone.equals(receipt.getCustomerPhone()))
                .collect(Collectors.toList());
    }
}
