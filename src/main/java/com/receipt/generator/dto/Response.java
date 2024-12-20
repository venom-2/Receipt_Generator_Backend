package com.receipt.generator.dto;

import lombok.Data;

@Data
public class Response {
    private Integer status;
    private String message;

    public Response() {
    }

    public Response(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
