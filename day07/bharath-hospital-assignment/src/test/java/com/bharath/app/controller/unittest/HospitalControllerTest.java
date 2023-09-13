package com.bharath.app.controller.unittest;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Test;
import com.bharath.app.controller.HospitalController;
import com.bharath.app.model.Hospital;
import com.bharath.app.model.Patient;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {
    @InjectMocks
    private HospitalController hospitalController = new HospitalController();

    @Test
    public void test_createPatient(){
        Patient patient = new Patient("Bharath","123","Mathruri","Fever");
        Patient result = hospitalController.createPatient(patient);
        assertEquals(patient.getPatientName(),result.getPatientName());
        assertEquals(patient.getPatientId(),result.getPatientId());
        assertEquals(patient.getHospitalName(),result.getHospitalName());
        assertEquals(patient.getDisease(),result.getDisease());

    }

    @Test
    public void test_showPatient(){
        Patient patient = new Patient("Bharath","123","Mathruri","Fever");
        hospitalController.createPatient(patient);
        Patient result = hospitalController.showPatient("Bharath");
        assertEquals("Bharath",result.getPatientName());
        assertEquals("123",result.getPatientId());
        assertEquals("Mathruri",result.getHospitalName());
        assertEquals("Fever",result.getDisease());
    }
    @Test
    public void test_updatePatient() {
        Patient patient = new Patient("Bharath","123","Mathrusri","Fever");
        hospitalController.createPatient(patient);
        Patient result = hospitalController.updatePatient("Bharath","Deccan");
        assertEquals("Bharath",result.getPatientName());
        assertEquals("123",result.getPatientId());
        assertEquals("Deccan",result.getHospitalName());
        assertEquals("Fever",result.getDisease());
    }
    @Test
    public void test_deletePatient() {
        Patient patient = new Patient("Bharath","123","Mathrusri","Fever");
        hospitalController.createPatient(patient);
        String result = hospitalController.deletePatient("Bharath");
        assertEquals("Patient Bharath removed successfully",result);
    }

    @Test
    public void test_createHospital() {
        Hospital hospital = new Hospital("Mathrusri","Chintamani","123");
        Hospital result = hospitalController.createHospital(hospital);
        assertEquals(hospital.getHospitalName(),result.getHospitalName());
        assertEquals(hospital.getAddresss(),result.getAddresss());
        assertEquals(hospital.getHospitalId(),result.getHospitalId());
    }

    @Test
    public void test_readHospital() {
        Hospital hospital = new Hospital("Mathrusri","Chintamani","123");
        hospitalController.createHospital(hospital);
        Hospital result = hospitalController.getHospital("Mathrusri");
        assertEquals("Mathrusri",result.getHospitalName());
        assertEquals("Chintamani",result.getAddresss());
        assertEquals("123",result.getHospitalId());
    }

    @Test
    public void test_editHospital() {
        Hospital hospital = new Hospital("Mathrusri","Chintamani","123");
        hospitalController.createHospital(hospital);
        Hospital result = hospitalController.changeAddress("Mathrusri","Chikkaballapur");
        assertEquals("Mathrusri",result.getHospitalName());
        assertEquals("Chikkaballapur",result.getAddresss());
        assertEquals("123",result.getHospitalId());
    }
    @Test
    public void test_deleteHospital() {
        Hospital hospital = new Hospital("Mathrusri","Chintamani","123");
        hospitalController.createHospital(hospital);
        String result = hospitalController.removeHospital("Mathrusri");
        assertEquals("Hospital Mathrusri Removed successfully",result);
    }

}