package com.example.demo.classes.repos;

import com.example.demo.classes.people.Guide;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GuideRepo extends CrudRepository<Guide, String> {
    List<Guide> getGuideByName(String name);

    List<Guide> getGuideById(UUID id);

    void deleteByName(String name);

}