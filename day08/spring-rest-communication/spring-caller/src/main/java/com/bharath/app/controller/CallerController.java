package com.bharath.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {
    private static final Logger logger= LoggerFactory.getLogger(CallerController.class);
    @Autowired
    private RestTemplate restTemplate;
    private String url="http://localhost:8082/receive";
    @GetMapping("/caller")
    public String getData(){
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET,null,String.class);
        logger.info(response.getStatusCode().toString());
        logger.info(response.getBody());
        return "Caller get:"+response.getBody();
    }
}
