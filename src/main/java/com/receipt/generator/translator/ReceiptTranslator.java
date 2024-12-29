package com.receipt.generator.translator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.generator.dto.ReceiptRequest;
import com.receipt.generator.entities.Receipt;
import org.springframework.stereotype.Component;

@Component
public class ReceiptTranslator {

    private static final ObjectMapper mapper = new ObjectMapper();

    public Receipt receiptRequestToReceipt(ReceiptRequest receiptRequest) {
        return mapper.convertValue(receiptRequest, Receipt.class);
    }
}
