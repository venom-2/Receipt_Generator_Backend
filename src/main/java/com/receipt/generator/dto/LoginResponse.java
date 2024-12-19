package com.receipt.generator.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private int status;
    private String msg;
    private String authToken;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getAuthToken() {
        return authToken;
    }

    public LoginResponse(int status, String authToken, String msg) {
        this.status = status;
        this.authToken = authToken;
        this.msg = msg;
    }

    public LoginResponse() {
    }
}
