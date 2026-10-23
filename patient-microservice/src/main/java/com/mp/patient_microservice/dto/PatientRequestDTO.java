package com.mp.patient_microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class PatientRequestDTO {
    // Validation annotations for the fields, the messages should support internationalization (i18n) 
    // and be placed in a messages.properties file or returned from a message source for better maintainability 
    // and localization support.
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth; // Consider using a Date type for better validation and formatting

    @NotBlank(message = "Registered Date is required")
    private String registeredDate; //This seems rather wrong, the registered date should be set by the system, not provided by the user.
}
