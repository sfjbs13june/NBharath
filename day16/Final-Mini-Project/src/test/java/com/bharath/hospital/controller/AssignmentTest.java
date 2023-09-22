package com.bharath.hospital.controller;


import com.bharath.hospital.model.Appointment;
import com.bharath.hospital.model.Prescription;
import com.bharath.hospital.repository.AppointmentRepository;
import com.bharath.hospital.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentTest {

    @InjectMocks
    private DoctorController doctorController;

    @InjectMocks
    private PatientController patientController;

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    public void getDoctorAppointmentTest() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        Appointment appointment = new Appointment("2","Bharath","Sridhar","22092023",prescription);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        when(appointmentRepository.findAll()).thenReturn(appointments);
        List<Appointment> result = (List<Appointment>) doctorController.getAppointments("Sridhar");
        for (Appointment ap:
             result) {
            assertEquals(appointment.getAppointmentId(),ap.getAppointmentId());
            assertEquals(appointment.getPatientName(),ap.getPatientName());
            assertEquals(appointment.getDoctorName(),ap.getDoctorName());
            assertEquals(appointment.getDate(),ap.getDate());
            assertEquals(appointment.getPrescription(),ap.getPrescription());
        }

    }

    @Test
    public void saveDoctorAppointmentTest() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        Appointment appointment = new Appointment("2","Bharath","Sridhar","22092023",prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = doctorController.saveAppointment(appointment);
        assertEquals("Appointment " + appointment.getAppointmentId() + " saved Successfully",response);
    }

    @Test
    public void getPatientAppointmentTest() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        Appointment appointment = new Appointment("2","Bharath","Sridhar","22092023",prescription);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        when(appointmentRepository.findAll()).thenReturn(appointments);
        List<Appointment> result = (List<Appointment>) patientController.getAppointments("Bharath");
        for (Appointment ap:
                result) {
            assertEquals(appointment.getAppointmentId(),ap.getAppointmentId());
            assertEquals(appointment.getPatientName(),ap.getPatientName());
            assertEquals(appointment.getDoctorName(),ap.getDoctorName());
            assertEquals(appointment.getDate(),ap.getDate());
            assertEquals(appointment.getPrescription(),ap.getPrescription());
        }
    }

    @Test
    public void savePatientAppointmentTest() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        Appointment appointment = new Appointment("2","Bharath","Sridhar","22092023",prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = patientController.saveAppointment(appointment);
        assertEquals("Appointment " + appointment.getAppointmentId() + " saved Successfully",response);
    }

    @Test
    public void viewPrescriptionTest() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        List<Prescription> list = new ArrayList<>();
        list.add(prescription);
        when(prescriptionRepository.findAll()).thenReturn(list);
        List<Prescription> response = (List<Prescription>) prescriptionController.getAllPrescriptions("Bharath");
        for (Prescription pr:
             response) {
            assertEquals(prescription.getPrescriptionId(),pr.getPrescriptionId());
            assertEquals(prescription.getAppointmentId(),pr.getAppointmentId());
            assertEquals(prescription.getPatientName(),pr.getPatientName());
            assertEquals(prescription.getDoctorName(),pr.getDoctorName());
            assertEquals(prescription.getDescription(),pr.getDescription());
        }

    }

    @Test
    public void savePrescription() {
        Prescription prescription = new Prescription("12a","2","The patient had fever","Bharath","Sridhar");
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        String response = prescriptionController.store(prescription);
        assertEquals("Prescription Saved successsfully",response);
    }


}
