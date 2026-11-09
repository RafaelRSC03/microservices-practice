package com.mp.patient_microservice.exceptions;

public class EmailAlreadyExistsException extends RuntimeException  {
    public EmailAlreadyExistsException(String message){
        super(message);
    }
    
}
