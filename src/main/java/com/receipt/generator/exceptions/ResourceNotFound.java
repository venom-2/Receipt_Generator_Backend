package com.receipt.generator.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){}

    public ResourceNotFound(String msg){
        super(msg);
    }

}
