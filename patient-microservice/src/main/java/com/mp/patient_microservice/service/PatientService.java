package com.mp.patient_microservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;

import com.mp.patient_microservice.dto.PatientRequestDTO;
import com.mp.patient_microservice.dto.PatientResponseDTO;
import com.mp.patient_microservice.exceptions.EmailAlreadyExistsException;
import com.mp.patient_microservice.exceptions.PatientNotFoundException;
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
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            String.format("Email %s already exists", patientRequestDTO.getEmail());
            throw new EmailAlreadyExistsException("Email already exists");
        }
        Patient patient = PatientMapper.requestToModel(patientRequestDTO);
        
        return PatientMapper.toDto(patientRepository.save(patient));
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        Patient patientToUpdate = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)){
            String.format("Email %s already exists", patientRequestDTO.getEmail());
            throw new EmailAlreadyExistsException("Email already exists");
        }

        patientToUpdate.setName(patientRequestDTO.getName());
        patientToUpdate.setEmail(patientRequestDTO.getEmail());
        patientToUpdate.setAddress(patientRequestDTO.getAddress());
        patientToUpdate.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patientToUpdate);
        return PatientMapper.toDto(updatedPatient);
    }

    public void deletePatient(UUID id){
        if(!patientRepository.existsById(id)){
            throw new PatientNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}
