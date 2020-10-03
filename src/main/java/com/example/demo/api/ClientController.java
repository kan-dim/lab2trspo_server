package com.example.demo.api;

import com.example.demo.classes.people.Client;
import com.example.demo.classes.people.ClientType;
import com.example.demo.classes.people.Language;
import com.example.demo.classes.service.ClientService;
import com.example.demo.classes.MappingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> clientsInfo(@RequestParam String name, @RequestParam MappingState state) {
        if (state == MappingState.all) return ResponseEntity.ok(service.clientInfo());
        return ResponseEntity.ok(service.getClientByName(name));
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestParam String name, @RequestParam Language language, ClientType type) {
        return ResponseEntity.ok(service.addNewClient(name, language, type));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteClientByName(@RequestParam String name) {
        return ResponseEntity.ok(service.deleteClientByName(name));
    }
}