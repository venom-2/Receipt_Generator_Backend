package com.receipt.generator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    private String name;
    private String companyName;
    private String email;
    private String mobileNumber;
    private String country;
    private String state;
    private String password;
}

