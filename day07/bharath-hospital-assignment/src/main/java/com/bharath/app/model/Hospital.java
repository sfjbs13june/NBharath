package com.bharath.app.model;


import org.springframework.stereotype.Controller;

@Controller
public class Hospital {

    String hospitalName;
    String addresss;
    String hospitalId;

    public Hospital() {}

    public Hospital(String hospitalName, String addresss, String hospitalId) {
        this.hospitalName = hospitalName;
        this.addresss = addresss;
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
}
