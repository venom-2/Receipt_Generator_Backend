package com.receipt.generator.entities;

import lombok.Data;

@Data
public class Response {
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response() {
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
