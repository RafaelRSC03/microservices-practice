package com.mp.patient_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mp.patient_microservice.dto.PatientRequestDTO;
import com.mp.patient_microservice.dto.PatientResponseDTO;
import com.mp.patient_microservice.mapper.PatientMapper;
import com.mp.patient_microservice.model.Patient;
import com.mp.patient_microservice.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
/**
 * Added AllArgsConstructor because even though @Autowired over each field injection is fine, 
 * it is best to inject it through constructor
 * PatientService
 */
public class PatientService {
    
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDto).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient patient = PatientMapper.requestToModel(patientRequestDTO);
        return PatientMapper.toDto(patientRepository.save(patient));
    }
}
