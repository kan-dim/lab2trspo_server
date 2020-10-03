package com.example.demo.api;

import com.example.demo.classes.MappingState;
import com.example.demo.classes.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/excursion")
public class ExcursionController {

    private final ExcursionService service;

    @Autowired
    public ExcursionController(ExcursionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> excursionInfo(@RequestParam String name, @RequestParam MappingState state) {
        if (state == MappingState.all) return ResponseEntity.ok(service.excursionsInfo());
        return ResponseEntity.ok(service.getExcursionByGuideName(name));
    }

    @PostMapping
    public ResponseEntity<String> addNewExcursion( @RequestParam int day, @RequestParam int month,
                                              @RequestParam int duration, @RequestParam int visitors,
                                              @RequestParam String guideName) {
        return ResponseEntity.ok(service.addNewExcursion( day, month, duration, visitors, guideName));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteExcursionByGuideName(@RequestParam String name) {
        return ResponseEntity.ok(service.deleteExcursionByGuideName(name));
    }
}