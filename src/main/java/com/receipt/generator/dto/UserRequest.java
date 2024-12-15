package com.receipt.generator.dto;

public class UserRequest {
    private String name;
    private String companyName;
    private String email;
    private String mobileNumber;
    private String country;
    private String state;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String name, String companyName, String email, String mobileNumber, String country, String state, String password) {
        this.name = name;
        this.companyName = companyName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.country = country;
        this.state = state;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
