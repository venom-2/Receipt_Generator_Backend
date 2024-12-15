package com.receipt.generator.exceptions;

public class DuplicateResource extends RuntimeException{

    public DuplicateResource(){}

    public DuplicateResource(String msg){
        super(msg);
    }

}
