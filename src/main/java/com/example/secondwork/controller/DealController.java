package com.example.secondwork.controller;

import com.example.secondwork.CrudController;
import com.example.secondwork.dao.DealDAO;
import com.example.secondwork.model.Deal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deals")
public class DealController {
    private final DealDAO dealDAO;
    CrudController _crudController;

    @Autowired
    public DealController(DealDAO dealDAO) {
        this.dealDAO = dealDAO;
        _crudController = new CrudController(dealDAO);
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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Make new deal");
        model.addAttribute("deal", new Deal());
        return "estate/deal/add";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("deal") Deal deal) {
        _crudController.insert(deal);
        return "redirect:/deals";
    }
}