package com.bharath.db.model;



import org.springframework.data.annotation.Id;

public class Hospital {

    @Id
    String hospitalId;
    String hospitalName;
    String address;




    public Hospital(String hospitalId, String hospitalName, String address) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
