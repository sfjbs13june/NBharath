package com.bharath.app.controller;

import com.bharath.app.model.Hospital;
import com.bharath.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {

    Map<String, Patient> patientMap = new HashMap<>();

    Map<String, Hospital> hospitalMap = new HashMap<>();

    @PostMapping("/savepatient")
    public Patient createPatient(@RequestBody Patient patient) {
        patientMap.put(patient.getPatientName(),patient);
        return patient;
    }

    @GetMapping("/patientrecords")
    public Patient showPatient(@RequestParam String name) {
        Patient patient = patientMap.get(name);
        return patient;
    }

    @PutMapping("/editpatient")
    public Patient updatePatient(@RequestParam("name") String name,@RequestParam("hospital") String hospital) {
        Patient patient = patientMap.get(name);
        patient.setHospitalName(hospital);
        patientMap.put(name,patient);
        return patientMap.get(name);
    }

    @DeleteMapping("/deletepatient")
    public String deletePatient(@RequestParam("name") String name) {
        patientMap.remove(name);
        return "Patient " + name + " removed successfully";
    }

    @GetMapping("/hospitaldetails")
    public Hospital getHospital(@RequestParam("name") String name) {
        Hospital hospital = hospitalMap.get(name);
        return  hospital;
    }

    @PostMapping("/addhospital")
    public Hospital createHospital(@RequestBody Hospital hospital) {
        hospitalMap.put(hospital.getHospitalName(),hospital);
        return hospital;
    }

    @PutMapping("/edithospital")
    public Hospital changeAddress(@RequestParam("name") String name,@RequestParam("address") String address) {
        Hospital hospital = hospitalMap.get(name);
        hospital.setAddresss(address);
        hospitalMap.put(name,hospital);
        return hospitalMap.get(name);
    }

    @DeleteMapping("/deletehospital")
    public String removeHospital(@RequestParam("name") String name) {
        hospitalMap.remove(name);
        return "Hospital "+ name + " Removed successfully";
    }



}
