package com.bharath.app.controller;

import com.bharath.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {

    Map<String, Patient> patientMap = new HashMap<>();

    @PostMapping("/save")
    public Patient createPatient(@RequestBody Patient patient) {
        patientMap.put(patient.getPatientName(),patient);
        return patient;
    }

    @GetMapping("/read")
    public Patient showPatient(@RequestParam String name) {
        Patient patient = patientMap.get(name);
        return patient;
    }
}
