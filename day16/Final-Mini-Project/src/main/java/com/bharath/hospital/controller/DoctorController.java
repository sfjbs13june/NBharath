package com.bharath.hospital.controller;


import com.bharath.hospital.model.Appointment;
import com.bharath.hospital.repository.AppointmentRepository;
import com.bharath.hospital.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/doctorappointment")
    public @ResponseBody Object getAppointments(@RequestParam final String doctorName) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> required = new ArrayList<>();
        for (Appointment appointment :
                appointments) {
            if (appointment.getDoctorName().equals(doctorName)) {
                required.add(appointment);
            }
        }

        return required.size()>0?required:"No Appointments Found";
    }

    @PostMapping("/save")
    public @ResponseBody String saveAppointment(@RequestBody final Appointment appointment) {
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            if(ap.getAppointmentId().equals(appointment.getAppointmentId())) {
                return "Appointment ID already exists";
            }

            if(ap.getDoctorName().equals(appointment.getDoctorName()) && ap.getPatientName().equals(appointment.getPatientName())){
                return "Appointment already exists for " + appointment.getPatientName() + " with Dr. " + appointment.getDoctorName();
            }

            if( ap.getPrescription().getPrescriptionId().equals(appointment.getPrescription().getPrescriptionId())) {
                return "Prescription ID already exists";
            }
        }
        if(appointment.getAppointmentId().equals(appointment.getPrescription().getAppointmentId()) &&
                appointment.getPatientName().equals(appointment.getPrescription().getPatientName()) &&
                appointment.getDoctorName().equals(appointment.getPrescription().getDoctorName())
        ) {
            appointmentRepository.save(appointment);
            prescriptionRepository.save(appointment.getPrescription());
            return "Appointment " + appointment.getAppointmentId() + " saved Successfully";
        }
        else return "Please check the input Data";
    }
}
