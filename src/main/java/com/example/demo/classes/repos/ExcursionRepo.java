package com.example.demo.classes.repos;

import com.example.demo.classes.excursion.Excursion;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ExcursionRepo extends CrudRepository<Excursion, String> {
    List<Excursion> getExcursionByGuide(UUID id);

    List<Excursion> getExcursionById(UUID id);


    List<Excursion> getExcursionByDate(Date date);

    void deleteByGuide(UUID id);

}