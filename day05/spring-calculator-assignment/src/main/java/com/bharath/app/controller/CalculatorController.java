package com.bharath.app.controller;

import com.bharath.app.process.MyCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final MyCalculator myCalculator;

    public CalculatorController(MyCalculator myCalculator)
    {
        this.myCalculator = myCalculator;
    }
    @GetMapping("/add")
    public double addition(@RequestParam("a") int a,@RequestParam("b") int b) { return a+b; }

    @GetMapping("/sub")
    public double subtraction(@RequestParam("a") int a,@RequestParam("b") int b) {
        return a-b;
    }

    @GetMapping("/mul")
    public double multiplication(@RequestParam("a") int a,@RequestParam("b")int b) {
        return a*b;
    }

    @GetMapping("/div")
    public double division(@RequestParam("a") int a,@RequestParam("b") int b) {
        return a/b;
    }

    @GetMapping("/addstr")
    public String addString(@RequestParam("a") String str1, @RequestParam("b") String str2) {
        return myCalculator.addString(str1,str2);
    }

    @GetMapping("/avgdata")
    public double averageValue(@RequestParam("a") int a, @RequestParam("b") int b){ return myCalculator.averageData(a,b);}
}
