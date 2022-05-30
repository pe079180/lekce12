package com.engeto.lekce12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrvniController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world ...";
    }

    @GetMapping("/helloJson")
    public Ucitel helloTeacher(){
        Ucitel ucitel = new Ucitel();
        ucitel.setJmeno("Amos");
        ucitel.setPrijmeni("Komensky");

        return ucitel;
    }
}
