package com.example.secondwork.dao;

import com.example.secondwork.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDAO {

    private static int CLIENT_COUNT;
    private List<Client> clients;
    {
        clients = new ArrayList<>();

        clients.add(new Client(++CLIENT_COUNT, "John Doe", "john@example.com", "+123456789", 100000.0));
        clients.add(new Client(++CLIENT_COUNT, "Jane Smith", "jane@example.com", "+987654321", 80000.0));
        clients.add(new Client(++CLIENT_COUNT, "Bob Johnson", "bob@example.com", "+567890123", 120000.0));
        clients.add(new Client(++CLIENT_COUNT, "Alice Brown", "alice@example.com", "+999888777", 75000.0));
        clients.add(new Client(++CLIENT_COUNT, "Charlie Davis", "charlie@example.com", "+111223344", 95000.0));
    }

    public List<Client> index(){
        return clients;
    }

    public Client show(int id){
        return clients.stream().filter(client -> client.getId() == id).findAny().orElse(null);
    }
}
