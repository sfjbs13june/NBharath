package com.bharath.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @GetMapping("/read")
    public String getData(){
        return "Provide all the data";
    }

    @PostMapping("/create")
    public String postData(){
        return "Add required data";
    }

    @PutMapping("/update")
    public String putData(){
        return "Update the data";
    }

    @DeleteMapping("/delete")
    public String deleteData(){
        return "Delete the data";
    }
}
