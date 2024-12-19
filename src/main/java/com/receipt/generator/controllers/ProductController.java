package com.receipt.generator.controllers;

import com.receipt.generator.configuration.SecurityConfig;
import com.receipt.generator.dto.ProductRequest;
import com.receipt.generator.entities.Product;
import com.receipt.generator.services.ProductService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getProducts() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return productService.getProducts(email);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}
