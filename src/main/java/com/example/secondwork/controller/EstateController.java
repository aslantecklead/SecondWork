package com.example.secondwork.controller;

import com.example.secondwork.dao.EstateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estates")
public class EstateController {
    private EstateDAO _estateDAO;

    @Autowired
    public EstateController(EstateDAO estateDAO) {
        _estateDAO = estateDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("estate", _estateDAO.index());
        return "estate/estate/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("estate", _estateDAO.show(id));
        return "estate/estate/show";
    }
}