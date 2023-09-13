package com.bharath.db.model;


import org.springframework.data.annotation.Id;

public class Patient {

    @Id
    private String patientId;

    private String patientName;

    private String hospitalName;

    private String disease;

    public Patient() {}

    public Patient(String patientId, String patientName, String hospitalName, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.hospitalName = hospitalName;
        this.disease = disease;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
