package com.bharath.app.model;


import org.springframework.stereotype.Component;

@Component
public class Patient {

String patientName;
String patientId;
String hospitalName;
String disease;

    public Patient() {}

    public Patient(String patientName,String patientId, String hospitalName, String disease) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.hospitalName = hospitalName;
        this.disease = disease;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
