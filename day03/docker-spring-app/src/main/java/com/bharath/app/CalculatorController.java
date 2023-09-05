package com.bharath.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public double add() {
        return 9+3;
    }

    @GetMapping("/sub")
    public double sub() {
        return 9-3;
    }

    @GetMapping("/div")
    public double div() {
        return 9/3;
    }

    @GetMapping("/mul")
    public double mul() {
        return 9*3;
    }
}