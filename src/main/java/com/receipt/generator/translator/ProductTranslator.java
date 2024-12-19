package com.receipt.generator.translator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.generator.dto.ProductRequest;
import com.receipt.generator.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductTranslator {

    private static final ObjectMapper mapper = new ObjectMapper();

    public Product productRequestToProduct(ProductRequest productRequest) {
        return mapper.convertValue(productRequest, Product.class);
    }
}
