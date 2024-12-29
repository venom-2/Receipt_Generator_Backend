package com.receipt.generator.dto;

import com.receipt.generator.entities.JewellerItems;
import com.receipt.generator.enums.ReceiptType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReceiptRequest {

    //Owner Details
    private String businessName;
    private String address;
    private Long phone;
    private String documentTitle;

    // Customer Details
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    //Receipt Details
    private String billNumber;
    private LocalDate date;
    private Double _24kRate;
    private Double silverBhav;

    //Term and Condition Details
    private String _18kReturn;
    private String _20kReturn;
    private String _22kReturn;

    //Relation with user
    private String user;

    // Receipt type
    private ReceiptType receiptType;

    // Items
    private List<JewellerItems> items;

    // Total and due
    private Double closingBalance;
    private Double previousDue;
    private Double currentDue;
    private Double paidAmount;
    private Double totalNetWeight;

    public ReceiptRequest() {
    }

    public ReceiptRequest(String businessName, String address, Long phone, String documentTitle, String customerName, String customerAddress, String customerPhone, String billNumber, LocalDate date, Double _24kRate, Double silverBhav, String _18kReturn, String _20kReturn, String _22kReturn, String user, ReceiptType receiptType, List<JewellerItems> items, Double closingBalance, Double previousDue, Double currentDue, Double paidAmount, Double totalNetWeight) {
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
        this.receiptType = receiptType;
        this.items = items;
        this.closingBalance = closingBalance;
        this.previousDue = previousDue;
        this.currentDue = currentDue;
        this.paidAmount = paidAmount;
        this.totalNetWeight = totalNetWeight;
    }

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
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

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double get_24kRate() {
        return _24kRate;
    }

    public void set_24kRate(Double _24kRate) {
        this._24kRate = _24kRate;
    }

    public Double getSilverBhav() {
        return silverBhav;
    }

    public void setSilverBhav(Double silverBhav) {
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

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    public List<JewellerItems> getItems() {
        return items;
    }

    public void setItems(List<JewellerItems> items) {
        this.items = items;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Double getPreviousDue() {
        return previousDue;
    }

    public void setPreviousDue(Double previousDue) {
        this.previousDue = previousDue;
    }

    public Double getCurrentDue() {
        return currentDue;
    }

    public void setCurrentDue(Double currentDue) {
        this.currentDue = currentDue;
    }

    public Double getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(Double totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
