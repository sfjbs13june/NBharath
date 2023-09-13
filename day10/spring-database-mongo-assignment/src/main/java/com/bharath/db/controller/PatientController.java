package com.bharath.db.controller;
import com.bharath.db.model.Patient;
import com.bharath.db.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;


    @PostMapping(value = "/savepatient")
    public @ResponseBody String store(@RequestBody final Patient patient) {
        patientRepository.save(patient);
        return "Patient Saved";
    }

    @GetMapping(value = "/patientrecords")
    public @ResponseBody Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    @PutMapping(value = "/editpatient")
    public @ResponseBody String store(@RequestParam("name") String name,@RequestParam("hospital") String hospital) {
        List<Patient> list = patientRepository.findAll();
        if(list.size()<1) return "Patient Records are Empty";
        for (Patient hp: list){
            if(hp.getPatientName().equals(name)) {
                hp.setHospitalName(hospital);
                patientRepository.save(hp);
                return "Patient " + hp.getPatientName() + " Updated";
            }
        }
        return "Patient Not Found";
    }

    @DeleteMapping(value = "/deletepatient")
    public @ResponseBody
    String store(@RequestParam("name") final String name) {
        List<Patient> list = patientRepository.findAll();
        if(list.size()<1) return "Patient Records are Empty";
        for (Patient hp: list){
            if(hp.getPatientName().equals(name)) {
                patientRepository.delete(hp);
                return "Patient " + hp.getPatientName() + " Deleted";
            }
        }
        return "Patient Not found";
    }

}