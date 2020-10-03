package com.example.demo.classes.excursion;


import com.example.demo.classes.people.Guide;
import com.example.demo.classes.service.GuideService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
@EnableAutoConfiguration
public class Excursion {

    private Date date;

    private int duration;
    private int visitors;
    private String guideName;
    @Id
    private UUID id;

    private UUID guide;

    public Excursion(int day, int month, int duration, int visitors, UUID guide, String guideName ) {

        Calendar calendar = new GregorianCalendar(2020, month - 1, day);
        this.date = calendar.getTime();

        this.duration = duration;
        this.visitors = visitors;
        this.guideName = guideName;

        this.guide = guide;

        this.id = UUID.randomUUID();

    }

    public Excursion() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGuide() {
        return guide;
    }

    public void setGuide(UUID guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return ("\t\n --- EXCURSION ---" +
                "\t\nИдентификатор экскурсии: " + id +
                "\n\tДлительность: " + duration +
                "\n\tКоличество посетителей: " + visitors +
                "\n\tДата проведения: " + date +
                "\n\tИмя экскурсовода: " + guideName + "\n");
    }
}
