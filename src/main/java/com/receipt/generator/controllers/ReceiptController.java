package com.receipt.generator.controllers;

import com.receipt.generator.entities.Receipt;
import com.receipt.generator.services.ReceiptService;
import com.receipt.generator.utilities.JwtUtility;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receipt")
@CrossOrigin(origins = "*" )
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @Autowired
    JwtUtility jwtUtility;

    @PostMapping("/save")
    public ResponseEntity<?> saveReceipt(@RequestBody Receipt receipt) throws Exception {
        return receiptService.saveReceipt(receipt);
    }

    @GetMapping("/fetch/{userEmail}")
    public ResponseEntity<?> fetchReceipt(@PathVariable String userEmail) throws Exception {
        return receiptService.fetchReceipt(userEmail);
    }

    @GetMapping("/fetch/customer/receipts/{customerPhone}")
    public ResponseEntity<?> fetchCustomerReceipt(@PathVariable String customerPhone, @RequestHeader("Authorization") String authorizationHeader) throws Exception {

        String token = authorizationHeader.startsWith("Bearer") ? authorizationHeader.substring(7) : authorizationHeader;

        // Validate the token and extract claims
        Claims claims = jwtUtility.validateToken(token);

        // Extract the email or any other information from the claims if needed
        String email = claims.getSubject();

        // Proceed with fetching the customer receipt using the phone number
        return receiptService.fetchCustomerReceipt(customerPhone, email);
    }

    @DeleteMapping("/delete/{billNumber}")
    public ResponseEntity<?> deleteReceipt(@PathVariable String billNumber, @RequestHeader("Authorization") String authorizationHeader) throws Exception {

        String token = authorizationHeader.startsWith("Bearer") ? authorizationHeader.substring(7) : authorizationHeader;

        // Validate the token and extract claims
        Claims claims = jwtUtility.validateToken(token);

        // Extract the email or any other information from the claims if needed
        String email = claims.getSubject();

        return receiptService.deleteReceipt(billNumber, email);
    }
}
