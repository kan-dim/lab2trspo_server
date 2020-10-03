package com.example.demo.classes.service;

import com.example.demo.classes.people.Guide;
import com.example.demo.classes.people.Manager;
import com.example.demo.classes.repos.GuideRepo;
import com.example.demo.classes.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GuideService {

    private final GuideRepo repos;

    @Autowired
    public GuideService(GuideRepo repos) {
        this.repos = repos;
    }


    public Guide addNewGuide(String name, boolean knowEnglish) {
        Guide guide = new Guide(name, knowEnglish);
        repos.save(guide);
        return guide;
    }

    public boolean deleteGuideByName(String name) {
        List<Guide> list = repos.getGuideByName(name);
        if (list.size() == 0) return false;
        repos.delete(list.get(0));
        return true;
    }

    public String getGuideByName(String name) {
        List<Guide> list = repos.getGuideByName(name);
        return list.get(0).toString();
    }

     public Boolean toggleGuideFreeState(String name) {
        Guide guide = repos.getGuideByName(name).get(0);
        guide.toggleFreeState();
        repos.save(guide);
        return true;
    }



    public String guideInfo() {
        List<Guide> list = (List<Guide>) repos.findAll();
        int listSize = list.size();
        if (listSize == 0) {
            return "Guides list is empty";
        }
        String result = "Guide`s INFO:  ";

        for (int i = 0; i < listSize; i++) {
            result = result + "\n" + list.get(i);
        }
        return result;
    }
}
