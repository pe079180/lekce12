package com.engeto.lekce12;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// controler slouzi k tomu aby se tam definovaly API

@RestController
public class PrvniController {
    Map<String, Ucitel> zakladDB = new HashMap<>();
    //Integer idSequence = 0;

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

//    @GetMapping("/teachers/{id}")
//    public Ucitel getTeacherById(@PathVariable String id) {
//        //
//        Map<String, Ucitel> zakladDB = new HashMap<>();
//
//        Ucitel ucitel = new Ucitel();
//        ucitel.setJmeno("Amos");
//        ucitel.setPrijmeni("Komensky");
//
//        Ucitel ucitel2 = new Ucitel();
//        ucitel2.setJmeno("Jan");
//        ucitel2.setPrijmeni("Návrat");
//
//        zakladDB.put("1", ucitel);
//        zakladDB.put("2", ucitel2);
//
//        return zakladDB.get(id);
//    }

    @GetMapping("/teachers/{id}")
    public Ucitel getTeacherById(@PathVariable String id) {
        return zakladDB.get(id);
    }

    @GetMapping("/teachers")
    public Collection<Ucitel> getAllTeachers() {
        return zakladDB.values();
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable String id) {
        zakladDB.remove(id);
    }

    @PostMapping("/teachers")
    public Ucitel saveTeacher(@RequestBody Ucitel ucitel) {
        Integer id = zakladDB.size() + 1; //není uplne ok
        //idSequence +=1; // taky není ok
        ucitel.setId(id.toString());
        zakladDB.put(id.toString(), ucitel);
        return ucitel;
    }

    @PutMapping("/teachers/{id}")
    public Ucitel updateTeacher(@RequestBody Ucitel ucitel, @PathVariable String id) {
        zakladDB.put(id, ucitel);
        return ucitel;
    }
}
