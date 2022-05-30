package com.engeto.lekce12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PrvniController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world ...";
    }

    @GetMapping("/helloJson")
    public Ucitel helloTeacher() {
        Ucitel ucitel = new Ucitel();
        ucitel.setJmeno("Amos");
        ucitel.setPrijmeni("Komensky");

        return ucitel;
    }

    @GetMapping("/helloParams")
    public Ucitel helloTeacherWithParams(@RequestParam String jmeno, @RequestParam String prijmeni) {
        Ucitel ucitel = new Ucitel();
        ucitel.setJmeno(jmeno);
        ucitel.setPrijmeni(prijmeni);

        return ucitel;
    }

    @GetMapping("/teachers/{id}")
    public Ucitel getTeacherById(@PathVariable String id) {
        //
        Map<String, Ucitel> zakladDB = new HashMap<>();

        Ucitel ucitel = new Ucitel();
        ucitel.setJmeno("Amos");
        ucitel.setPrijmeni("Komensky");

        Ucitel ucitel2 = new Ucitel();
        ucitel2.setJmeno("Jan");
        ucitel2.setPrijmeni("Návrat");

        zakladDB.put("1", ucitel);
        zakladDB.put("2", ucitel2);

        return zakladDB.get(id);
    }

}
