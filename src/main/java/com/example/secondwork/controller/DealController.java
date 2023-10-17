package com.example.secondwork.controller;

import com.example.secondwork.dao.DealDAO;
import com.example.secondwork.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/deals")
public class DealController {
    private final DealDAO dealDAO;

    @Autowired
    public DealController(DealDAO dealDAO) {
        this.dealDAO = dealDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("deals", dealDAO.index());
        return "estate/deal/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Deal deal = dealDAO.show(id);
        model.addAttribute("deal", deal);
        return "estate/deal/show";
    }
}
