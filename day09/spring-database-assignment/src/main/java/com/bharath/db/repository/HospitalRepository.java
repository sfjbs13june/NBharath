package com.bharath.db.repository;

import com.bharath.db.model.Hospital;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospitalRepository extends CrudRepository<Hospital, Integer>{
}

