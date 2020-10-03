package com.example.demo.classes.people;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@EnableAutoConfiguration
public class Guide {
    private String name;
    private boolean knowEnglish;
    private boolean isFree;
    @Id
    private UUID id;

    public Guide(String name, boolean knowEnglish) {
        this.name = name;
        this.knowEnglish = knowEnglish;
        this.isFree = true;
        this.id = UUID.randomUUID();
    }

    public Guide() {

    }

    public void toggleFreeState() {
        isFree = !this.isFree;
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

    public boolean getFreeState() {
        return isFree;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("\n\t --- GUIDE ---" +
                "\n\tИмя: " + name +
                "\n\tАнглийский знает?: " + (knowEnglish ? "Да" : "Нет") +
                "\n\t Свободен?: " + (isFree ? "Да" : "Нет") +
                "\n\t ID: " + id );
    }
}
