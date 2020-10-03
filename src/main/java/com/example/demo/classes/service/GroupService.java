package com.example.demo.classes.service;

import com.example.demo.classes.excursion.Excursion;
import com.example.demo.classes.excursion.Сlass;
import com.example.demo.classes.people.Manager;
import com.example.demo.classes.repos.ExcursionRepo;
import com.example.demo.classes.repos.GroupRepo;
import com.example.demo.classes.repos.ManagerRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {

    private final ManagerRepo managerRepo;
    private final GroupRepo groupRepo;
    private final ExcursionRepo excursionRepo;

    public GroupService(ManagerRepo managerRepo, GroupRepo groupRepo, ExcursionRepo excursionRepo) {
        this.managerRepo = managerRepo;
        this.groupRepo = groupRepo;
        this.excursionRepo = excursionRepo;
    }


    public String addNewGroup(int day, int month, String managerName, String clientsList) {
        if (!checkCorrectData(day, month)) {
            return "INCORRECT DATA";
        }

        Calendar calendar = new GregorianCalendar(2020, month - 1, day);
        Date date = calendar.getTime();

        Manager manager;
        try {
            manager = managerRepo.getManagerByName(managerName).get(0);
        } catch (Exception e) {
            return "MANAGER NOT FOUND";
        }
        Excursion excursion;
        try {
            excursion = excursionRepo.getExcursionByDate(date).get(0);
        } catch (Exception e) {
            return "EXCURSION ON THIS DATE NOT FOUND";
        }
        Сlass group = new Сlass(manager.getId(), excursion.getId(), clientsList);
        groupRepo.save(group);
        return "GROUP WAS CREATED";
    }

    public boolean deleteGroupByDate(int day, int month) {

        Calendar calendar = new GregorianCalendar(2020, month - 1, day);
        Date date = calendar.getTime();

        Excursion excursion = excursionRepo.getExcursionByDate(date).get(0);
        Сlass group = groupRepo.getGroupByExcursion(excursion.getId()).get(0);
        groupRepo.delete(group);
        return true;
    }

    public String getGroupByDate(int day, int month) {
        Calendar calendar = new GregorianCalendar(2020, month - 1, day);
        Date date = calendar.getTime();

        Excursion excursion = excursionRepo.getExcursionByDate(date).get(0);
        Сlass group = groupRepo.getGroupByExcursion(excursion.getId()).get(0);
        return groupInfo(group);
    }

    public String groupsInfo() {

        List<Сlass> list = (List<Сlass>) groupRepo.findAll();
        int listSize = list.size();
        if (listSize == 0) {
            return "Groups list is empty";
        }
        String result = "Groups`s INFO:  ";

        for (int i = 0; i < listSize; i++) {
            result = result + "\n" + groupInfo(list.get(i));
        }
        return result;
    }

    public String groupInfo(Сlass group) {
        Excursion excursion = excursionRepo.getExcursionById(group.getExcursion()).get(0);
        Manager manager = managerRepo.getManagerById(group.getManager()).get(0);
        return ("\n ***** GROUP *****" +
                "\n Менеджер: " + manager +
                "\n Экскурсия: " + excursion +
                "\n Имена клиентов: " + group.getClientsName());
    }


    public boolean checkCorrectData(int day, int month) {

        if (month == 2 && (day > 29 || day < 1)) return false;

        if (day < 1 || day > 31 || month < 1 || month > 12) return false;

        return true;
    }

}
