package com.example.demo.api;

import com.example.demo.classes.MappingState;
import com.example.demo.classes.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/groups")
public class GroupController {

    private final GroupService service;

    @Autowired
    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> excursionInfo(@RequestParam int day, @RequestParam int month, @RequestParam MappingState state) {
        if (state == MappingState.all) return ResponseEntity.ok(service.groupsInfo());
        return ResponseEntity.ok(service.getGroupByDate(day, month));
    }

    @PostMapping
    public ResponseEntity<String> addNewGroup(@RequestParam int day, @RequestParam int month,
                                              @RequestParam String clientsList, @RequestParam String managerName) {
        return ResponseEntity.ok(service.addNewGroup(day, month, managerName, clientsList));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteGroupByDate(@RequestParam int day, @RequestParam int month) {
        return ResponseEntity.ok(service.deleteGroupByDate(day, month));
    }
}