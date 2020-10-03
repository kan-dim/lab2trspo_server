package com.example.demo.classes.repos;

import com.example.demo.classes.people.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ManagerRepo extends CrudRepository<Manager, String> {
    List<Manager> getManagerByName(String name);

    List<Manager> getManagerById(UUID id);

    void deleteByName(String name);

}