package com.mp.patient_microservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.patient_microservice.model.Patient;

@Repository 
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    
}
