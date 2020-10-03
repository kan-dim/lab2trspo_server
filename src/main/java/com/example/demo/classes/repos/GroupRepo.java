
package com.example.demo.classes.repos;

import com.example.demo.classes.excursion.Сlass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GroupRepo extends CrudRepository<Сlass, String> {
    List<Сlass> getGroupByManager(UUID id);

    List<Сlass> getGroupByExcursion(UUID id);

    List<Сlass> getExcursionById(UUID id);

    void deleteByExcursion(UUID id);

}