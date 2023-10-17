package com.example.secondwork.controller;

import com.example.secondwork.dao.OfferDAO;
import com.example.secondwork.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferDAO offerDAO;

    @Autowired
    public OfferController(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @GetMapping()
    public String index(Model model) {
        List<Offer> offers = offerDAO.index();
        model.addAttribute("offers", offers);
        return "estate/offer/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Offer offer = offerDAO.show(id);
        model.addAttribute("offer", offer);
        return "estate/offer/show";
    }
}
