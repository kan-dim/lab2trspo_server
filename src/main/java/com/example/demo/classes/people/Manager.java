package com.example.demo.classes.people;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@EnableAutoConfiguration
public class Manager {

    private String name;
    private boolean knowEnglish;
    @Id
    private UUID id;

    public Manager(String name, boolean knowEnglish) {
        this.name = name;
        this.knowEnglish = knowEnglish;
        this.id = UUID.randomUUID();
    }

    public Manager() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKnowEnglish() {
        return knowEnglish;
    }

    public void setKnowEnglish(boolean knowEnglish) {
        this.knowEnglish = knowEnglish;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("\n\t--- MANAGER --- " +
                "\n\tИмя: " + name +
                "\n\tАнглийский знает?: " + (knowEnglish ? "Да" : "Нет") + "\n");
    }
}

