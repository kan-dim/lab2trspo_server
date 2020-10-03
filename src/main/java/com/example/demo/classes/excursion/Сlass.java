package com.example.demo.classes.excursion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@EnableAutoConfiguration
public class Сlass {

    private UUID manager;

    private UUID excursion;
    private String clientsName;
    @Id
    private UUID id;

    public Сlass(UUID manager, UUID excursion, String clientsName) {
        this.manager = manager;
        this.excursion = excursion;
        this.clientsName = clientsName;
        this.id = UUID.randomUUID();

    }

    public Сlass() {

    }

    public UUID getManager() {
        return manager;
    }

    public void setManager(UUID manager) {
        this.manager = manager;
    }

    public UUID getExcursion() {
        return excursion;
    }

    public void setExcursion(UUID excursion) {
        this.excursion = excursion;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("\n ***** GROUP *****" +
                "\n Менеджер: " + manager +
                "\n Экскурсия: " + excursion +
                "\n Имена клиентов: " + clientsName);
    }
}
