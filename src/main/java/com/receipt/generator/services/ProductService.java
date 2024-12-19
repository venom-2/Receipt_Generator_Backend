package com.receipt.generator.services;

import com.receipt.generator.dao.ProductDAO;
import com.receipt.generator.dto.ProductRequest;
import com.receipt.generator.entities.Product;
import com.receipt.generator.entities.Response;
import com.receipt.generator.translator.ProductTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductTranslator productTranslator;

    public ResponseEntity<?> getProducts(String email) throws Exception {
        List<Product> products = productDAO.getProducts(email);
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<?> saveProduct(ProductRequest productRequest) {
        Product product = productTranslator.productRequestToProduct(productRequest);
        Response response = productDAO.saveProduct(product);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    public ResponseEntity<?> updateProduct(Product product) {
        Response response = productDAO.updateProduct(product);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    public ResponseEntity<?> deleteProduct(String id) {
        Response response = productDAO.deleteProduct(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
