package com.mp.patient_microservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.patient_microservice.dto.PatientRequestDTO;
import com.mp.patient_microservice.dto.PatientResponseDTO;
import com.mp.patient_microservice.service.PatientService;

import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/patients")
@AllArgsConstructor 
public class PatientController {

    private final PatientService patientService;

    @GetMapping ("/getAll")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping ("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        try {
            PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
            return ResponseEntity.ok().body(patientResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    /* @PostMapping ("/update")
    public ResponseEntity<PatientResponseDTO> updatePatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        try {
            PatientResponseDTO patientResponseDTO = patientService.updatePatient(patientRequestDTO);
            return ResponseEntity.ok().body(patientResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    } */

}
