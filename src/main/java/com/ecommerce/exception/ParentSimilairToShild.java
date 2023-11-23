package com.ecommerce.exception;

public class ParentSimilairToShild extends RuntimeException {

    public ParentSimilairToShild(String message) {
        super(message);
    }
public ParentSimilairToShild(String message,Throwable cause){
        super(message,cause);
}
}
