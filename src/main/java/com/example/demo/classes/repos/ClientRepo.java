package com.example.demo.classes.repos;

import com.example.demo.classes.people.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepo extends CrudRepository<Client, String> {
    List<Client> getClientByName(String name);

    List<Client> getClientById(UUID id);

    void deleteByName(String name);

}