package com.bharath.hospital.repository;

import com.bharath.hospital.model.Appointment;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

}
