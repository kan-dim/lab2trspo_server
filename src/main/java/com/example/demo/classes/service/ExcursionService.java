package com.example.demo.classes.service;

import com.example.demo.classes.excursion.Excursion;
import com.example.demo.classes.people.Guide;
import com.example.demo.classes.repos.ExcursionRepo;
import com.example.demo.classes.repos.GuideRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExcursionService {

    private final ExcursionRepo excursionRepo;
    private final GuideRepo guideRepo;

    public ExcursionService(ExcursionRepo repos, GuideRepo guideRepo) {
        this.excursionRepo = repos;
        this.guideRepo = guideRepo;
    }


    public String addNewExcursion(int day, int month, int duration, int visitors, String guideName) {
        if (!checkCorrectData(day, month, duration)) {
            return "INCORRECT DATA";
        }

        Guide guide;
        try {
            guide = guideRepo.getGuideByName(guideName).get(0);
        } catch (Exception e) {
            return "GUIDE NOT FOUND";
        }
        if(!guide.getFreeState()){
            return "GUIDE IS NOT FREE. CHOOSE ANOTHER ONE";
        }
        guide.toggleFreeState();
        guideRepo.save(guide);
        Excursion excursion = new Excursion(day, month, duration, visitors, guide.getId(), guide.getName());
        excursionRepo.save(excursion);
        return "EXCURSION WAS CREATED";
    }

    public boolean deleteExcursionByGuideName(String guideName) {
        Guide guide;
        try {
            guide = guideRepo.getGuideByName(guideName).get(0);
        } catch (Exception e) {
            return false;
        }
        Excursion excursion = excursionRepo.getExcursionByGuide(guide.getId()).get(0);
        excursionRepo.delete(excursion);
        return true;
    }

    public String getExcursionByGuideName(String guideName) {
        Guide guide;
        try {
            guide = guideRepo.getGuideByName(guideName).get(0);
        } catch (Exception e) {
            return "GUIDE NOT FOUND";
        }

        Excursion excursion;

        try {
            excursion = excursionRepo.getExcursionByGuide(guide.getId()).get(0);
        } catch (Exception e) {
            return "EXCURSION NOT FOUND";
        }

        return excursion.toString();
    }

    public String excursionsInfo() {

        List<Excursion> list = (List<Excursion>) excursionRepo.findAll();
        int listSize = list.size();
        if (listSize == 0) {
            return "Excursion list is empty";
        }
        String result = "Excursion`s INFO:  ";

        for (int i = 0; i < listSize; i++) {
            UUID guideId = list.get(i).getGuide();
            Guide guide = guideRepo.getGuideById(guideId).get(0);
            result = result + "\n" + list.get(i);
        }
        return result;
    }

    public boolean checkCorrectData(int day, int month, int duration) {

        if (month == 2 && (day > 29 || day < 1))return false;

        if (day < 1 || day > 31 ||  month < 1 ||
            month > 12 ||  duration > 180 || duration < 0)  return false;

        return true;
    }
}

