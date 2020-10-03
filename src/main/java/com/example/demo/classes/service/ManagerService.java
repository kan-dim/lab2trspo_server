package com.example.demo.classes.service;

import com.example.demo.classes.people.Manager;
import com.example.demo.classes.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerService {

    private final ManagerRepo repos;

    @Autowired
    public ManagerService(ManagerRepo repos) {
        this.repos = repos;
    }

    public Manager addNewManager(String name, boolean knowEnglish) {
        Manager manager = new Manager(name, knowEnglish);
        repos.save(manager);
        return manager;
    }

    public boolean deleteManagerByName(String name) {
        List<Manager> list = repos.getManagerByName(name);
        if (list.size() == 0) return false;
        repos.delete(list.get(0));
        return true;
    }

    public String getManagerByName(String name) {
        List<Manager> list = repos.getManagerByName(name);
        return list.get(0).toString();
    }

    public String managersInfo() {
        List<Manager> list = (List<Manager>) repos.findAll();
        int listSize = list.size();
        if (listSize == 0) {
            return "Managers list is empty";
        }
        String result = "Manager`s INFO:  ";

        for (int i = 0; i < listSize; i++) {
            result = result + "\n" + list.get(i);
        }
        return result;
    }

}
