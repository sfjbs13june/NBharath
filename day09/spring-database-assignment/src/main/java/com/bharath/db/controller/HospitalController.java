package com.bharath.db.controller;

import com.bharath.db.model.Hospital;
import com.bharath.db.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

//    public List<Hospital> findAll() {
//        List<Hospital> hospitals = new ArrayList<>();
//        hospitalRepository.findAll().forEach(hospitals::add);
//        return hospitals;
//    }

    @PostMapping(value = "/savehospital")
    public @ResponseBody String store(@RequestBody final Hospital hospital) {
        hospitalRepository.save(hospital);
        return "Hospital Saved";
    }

     @GetMapping(value = "/hospitalrecords")
    public @ResponseBody Iterable<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @PutMapping(value = "/edithospital")
    public @ResponseBody String store(@RequestParam("name") String name,@RequestParam("address") String address) {
        List<Hospital> list = (List<Hospital>) hospitalRepository.findAll();
        if(list.size()<1) return "Hospital Records are Empty";
        for (Hospital hp: list){
            if(hp.getHospitalName().equals(name)) {
                hp.setAddress(address);
                hospitalRepository.save(hp);
                return "Hospital " + hp.getHospitalName() + " Updated";
            }
        }
        return "Hospital Not Found";
    }

    @DeleteMapping(value = "/deletehospital")
    public @ResponseBody
    String store(@RequestParam("name") final String name) {
        List<Hospital> list = (List<Hospital>) hospitalRepository.findAll();
        if(list.size()<1) return "Hospital Records are Empty";
        for (Hospital hp: list){
             if(hp.getHospitalName().equals(name)) {
                 hospitalRepository.deleteById(hp.getHospitalId());
                 return "Hospital " + hp.getHospitalName() + " Deleted";
             }
        }
        return "Hospital Not found";
    }


}
