package com.bharath.hospital.controller;

import com.bharath.hospital.model.Prescription;
import com.bharath.hospital.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public @ResponseBody Object getAllPrescriptions(@RequestParam final String patientName) {
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        List<Prescription> requiredPrescriptions = new ArrayList<>();
        for (Prescription prescription :prescriptionList) {
            if(prescription.getPatientName().equals(patientName)) {
                requiredPrescriptions.add(prescription);
            }
        }
        return requiredPrescriptions.size()>0?requiredPrescriptions:"No Prescriptions Found";
    }

    @PostMapping("/saveprescription")
    public @ResponseBody String store(@RequestBody final Prescription prescription) {
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        for (Prescription data:
             prescriptionList) {
            if(data.getPrescriptionId().equals(prescription.getPrescriptionId())) return "Prescription ID already exists";
            if(data.getAppointmentId().equals(prescription.getAppointmentId())) return "Appointment ID already exists";
        }
        prescriptionRepository.save(prescription);
        return "Prescription Saved successsfully";
    }
}
