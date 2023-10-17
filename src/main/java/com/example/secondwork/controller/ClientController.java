package com.example.secondwork.controller;

import com.example.secondwork.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estate")
public class ClientController {
    private ClientDAO _clientDAO;

    @Autowired
    public ClientController(ClientDAO clientDAO){
        _clientDAO = clientDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("client", _clientDAO.index());
        return "estate/client";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("client", _clientDAO.show(id));
        return "estate/client";
    }
}