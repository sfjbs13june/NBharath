package com.bharath.app.controller.componenttest;


import com.bharath.app.controller.HospitalController;
import com.bharath.app.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value="test")
public class HospitalControllerWeb {

    @Autowired
    private MockMvc mockMvc;

    @Value("${patient.create.url}")
    String create_patient;
    @Value("${patient.read.url}")
    String get_patient;
    @Value("${patient.update.url}")
    String edit_patient;
    @Value("${patient.delete.url}")
    String delete_patient;
    @Value("${hospital.create.url}")
    String create_hospital;
    @Value("${hospital.read.url}")
    String get_hospital;
    @Value("${patient.create.url}")
    String update_hospital;
    @Value("${patient.create.url}")
    String delete_hospital;

    @Test
    public void test_createPatient() throws Exception {
        Patient patient = new Patient("Bharath","123","Mathrusri","Fever");
        ResultActions resultActions = mockMvc.perform(post(create_patient).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
