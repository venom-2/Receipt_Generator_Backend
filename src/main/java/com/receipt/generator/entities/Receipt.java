package com.receipt.generator.entities;

import lombok.Data;

import java.util.List;

@Data
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String get_24kRate() {
        return _24kRate;
    }

    public void set_24kRate(String _24kRate) {
        this._24kRate = _24kRate;
    }

    public String getSilverBhav() {
        return silverBhav;
    }

    public void setSilverBhav(String silverBhav) {
        this.silverBhav = silverBhav;
    }

    public String get_18kReturn() {
        return _18kReturn;
    }

    public void set_18kReturn(String _18kReturn) {
        this._18kReturn = _18kReturn;
    }

    public String get_20kReturn() {
        return _20kReturn;
    }

    public void set_20kReturn(String _20kReturn) {
        this._20kReturn = _20kReturn;
    }

    public String get_22kReturn() {
        return _22kReturn;
    }

    public void set_22kReturn(String _22kReturn) {
        this._22kReturn = _22kReturn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<JewellerItems> getItems() {
        return items;
    }

    public void setItems(List<JewellerItems> items) {
        this.items = items;
    }

    public String getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(String closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getPreviousDue() {
        return previousDue;
    }

    public void setPreviousDue(String previousDue) {
        this.previousDue = previousDue;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCurrentDue() {
        return currentDue;
    }

    public void setCurrentDue(String currentDue) {
        this.currentDue = currentDue;
    }

    public String getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(String totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public Receipt(String businessName, String address, String phone, String documentTitle, String customerName, String customerAddress, String customerPhone, String billNumber, String date, String _24kRate, String silverBhav, String _18kReturn, String _20kReturn, String _22kReturn, String user, List<JewellerItems> items, String closingBalance, String previousDue, String currentDue, String paidAmount, String totalNetWeight) {
        this.businessName = businessName;
        this.address = address;
        this.phone = phone;
        this.documentTitle = documentTitle;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.billNumber = billNumber;
        this.date = date;
        this._24kRate = _24kRate;
        this.silverBhav = silverBhav;
        this._18kReturn = _18kReturn;
        this._20kReturn = _20kReturn;
        this._22kReturn = _22kReturn;
        this.user = user;
        this.items = items;
        this.closingBalance = closingBalance;
        this.previousDue = previousDue;
        this.currentDue = currentDue;
        this.paidAmount = paidAmount;
        this.totalNetWeight = totalNetWeight;
    }

    public Receipt() {
    }
}
