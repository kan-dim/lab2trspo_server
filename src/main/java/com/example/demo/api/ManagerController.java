package com.example.demo.api;

import com.example.demo.classes.people.Manager;
import com.example.demo.classes.service.ManagerService;
import com.example.demo.classes.MappingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    private final ManagerService service;

    @Autowired
    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> managersInfo(@RequestParam String name, @RequestParam MappingState state) {
        if (state == MappingState.all) return ResponseEntity.ok(service.managersInfo());
        return ResponseEntity.ok(service.getManagerByName(name));
    }

    @PostMapping
    public ResponseEntity<Manager> addManager(@RequestParam String name, @RequestParam boolean knowEnglish) {
        return ResponseEntity.ok(service.addNewManager( name, knowEnglish));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteManagerByName(@RequestParam String name) {
        return ResponseEntity.ok(service.deleteManagerByName(name));
    }
}