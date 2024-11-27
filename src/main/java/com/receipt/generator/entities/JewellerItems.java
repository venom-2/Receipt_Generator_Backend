package com.receipt.generator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewellerItems {
    private String description;
    private String gWt;
    private String lWt;
    private String nWt;
    private String tunch;
    private String rate;
    private String gold;
    private String silver;
    private String labour;
    private String amount;
}
