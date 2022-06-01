package com.engeto.lekce12;

import com.engeto.lekce12.entity.UcitelEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")    //automaticky se přidá do cesty   tzn např "/v2/teachers/{id}"
public class DruhyController {

    public DruhyController(UcitelService ucitelService) {
        this.ucitelService = ucitelService;
    }

    final UcitelService ucitelService;

    @GetMapping("/teachers/{id}")
    public UcitelEntity getTeacherById(@PathVariable Long id) {
        return ucitelService.getUcitelById(id);
    }

    @PostMapping("/teachers")
    public UcitelEntity saveTeacher(@RequestBody UcitelEntity ucitel) {
        ucitelService.saveUcitel(ucitel);
        return ucitel;
    }

    @GetMapping("/teachers")
    public Iterable<UcitelEntity> getAllTeachers() {
        return ucitelService.getAllUcitel();
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        ucitelService.deleteUcitelById(id);

    }    @PutMapping("/teachers/{id}")
    public UcitelEntity updateTeacher(@RequestBody UcitelEntity ucitel, @PathVariable String id) {
        ucitelService.saveUcitel(ucitel);
        return ucitel;
    }

}
