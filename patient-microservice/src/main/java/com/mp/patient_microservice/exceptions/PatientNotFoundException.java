package com.mp.patient_microservice.exceptions;

public class PatientNotFoundException extends RuntimeException  {
    public PatientNotFoundException(String message){
        super(message);
    }
    
}
