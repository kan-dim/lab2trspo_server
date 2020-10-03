package com.example.demo.classes.service;

import com.example.demo.classes.people.Client;
import com.example.demo.classes.people.ClientType;
import com.example.demo.classes.people.Language;
import com.example.demo.classes.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo repos;

    @Autowired
    public ClientService(ClientRepo repos) {
        this.repos = repos;
    }

    public Client addNewClient(String name, Language language, ClientType type) {
        Client client = new Client(name, type, language);
        repos.save(client);
        return client;
    }

    public boolean deleteClientByName(String name) {
        List<Client> list = repos.getClientByName(name);
        if (list.size() == 0) return false;
        repos.delete(list.get(0));
        return true;
    }

    public String getClientByName(String name) {
        List<Client> list = repos.getClientByName(name);
        return list.get(0).toString();
    }

    public String clientInfo() {
        List<Client> list = (List<Client>) repos.findAll();
        int listSize = list.size();
        if (listSize == 0) {
            return "Clients list is empty";
        }
        String result = "Client`s INFO:  ";

        for (int i = 0; i < listSize; i++) {
            result = result + "\n" + list.get(i);
        }
        return result;
    }
}
