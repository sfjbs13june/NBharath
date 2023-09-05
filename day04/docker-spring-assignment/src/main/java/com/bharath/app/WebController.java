package com.bharath.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @GetMapping("/name")
    public String name() {
        return "Bharath N" ;
    }

    @GetMapping("/age")
    public int sub() {
        return 23;
    }

    @GetMapping("/address")
    public String address() {
        return "#387 4th Cross Road Chikkamaranahalli Bangalore-54";
    }
}