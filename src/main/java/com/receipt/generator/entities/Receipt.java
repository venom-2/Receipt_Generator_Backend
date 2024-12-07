package com.receipt.generator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    //Owner Details
    private String businessName;
    private String address;
    private String phone;
    private String documentTitle;

    // Customer Details
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    //Receipt Details
    private String billNumber;
    private String date;
    private String _24kRate;
    private String silverBhav;

    //Term and Condition Details
    private String _18kReturn;
    private String _20kReturn;
    private String _22kReturn;

    //Relation with user
    private String user;

    // Items
    private List<JewellerItems> items;

    // Total and due
    private String closingBalance;
    private String previousDue;
    private String currentDue;
    private String paidAmount;
    private String totalNetWeight;
}
