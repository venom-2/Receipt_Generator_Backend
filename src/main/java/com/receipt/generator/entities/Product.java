package com.receipt.generator.entities;

import com.receipt.generator.enums.ProductType;
import lombok.Data;

@Data
public class Product {
    private String _id;
    private String user;
    private String itemName;
    private String gWt;
    private String lWt;
    private String nWt;
    private String tunch;
    private ProductType type;
    private Integer quantity;

    public Product() {
    }

    public Product(String _id, String user, String itemName, String gWt, String lWt, String nWt, String tunch, ProductType type, Integer quantity) {
        this._id = _id;
        this.user = user;
        this.itemName = itemName;
        this.gWt = gWt;
        this.lWt = lWt;
        this.nWt = nWt;
        this.tunch = tunch;
        this.type = type;
        this.quantity = quantity;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getgWt() {
        return gWt;
    }

    public void setgWt(String gWt) {
        this.gWt = gWt;
    }

    public String getlWt() {
        return lWt;
    }

    public void setlWt(String lWt) {
        this.lWt = lWt;
    }

    public String getnWt() {
        return nWt;
    }

    public void setnWt(String nWt) {
        this.nWt = nWt;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getTunch() {
        return tunch;
    }

    public void setTunch(String tunch) {
        this.tunch = tunch;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
