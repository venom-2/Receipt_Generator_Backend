package com.receipt.generator.dao;

import com.receipt.generator.entities.Product;
import com.receipt.generator.entities.Response;
import com.receipt.generator.exceptions.ResourceNotFound;
import com.receipt.generator.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getProducts(String email) throws Exception{
        List<Product> products = productRepository.findAllByUser(email);
        if(products.isEmpty()){
            throw new ResourceNotFound("No products are available!");
        }
        return products;
    }

    public Response saveProduct(Product product) {
        try{
            productRepository.save(product);
            return new Response(HttpStatus.CREATED.value(), "Product saved successfully!");
        } catch (Exception e) {
            return new Response(HttpStatus.PRECONDITION_FAILED.value(), "Failed to save the product!");
        }
    }

    public Response updateProduct(Product product) {
        try{
            productRepository.save(product);
            return new Response(HttpStatus.CREATED.value(), "Product updated successfully!");
        } catch (Exception e) {
            return new Response(HttpStatus.PRECONDITION_FAILED.value(), "Failed to update the product!");
        }
    }

    public Response deleteProduct(String id) {
        try{
            productRepository.deleteById(id);
            return new Response(HttpStatus.CREATED.value(), "Product deleted successfully!");
        } catch (Exception e) {
            return new Response(HttpStatus.PRECONDITION_FAILED.value(), "Failed to delete the product!");
        }
    }
}
