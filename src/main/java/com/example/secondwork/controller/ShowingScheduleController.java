package com.example.secondwork.controller;

import com.example.secondwork.dao.ShowingScheduleDAO;
import com.example.secondwork.model.ShowingSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/showing-schedules")
public class ShowingScheduleController {

    private final ShowingScheduleDAO showingScheduleDAO;

    @Autowired
    public ShowingScheduleController(ShowingScheduleDAO showingScheduleDAO) {
        this.showingScheduleDAO = showingScheduleDAO;
    }

    @GetMapping()
    public String index(Model model) {
        List<ShowingSchedule> showingSchedules = showingScheduleDAO.index();
        model.addAttribute("showingSchedules", showingSchedules);
        return "estate/showing-schedule/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        ShowingSchedule showingSchedule = showingScheduleDAO.show(id);
        model.addAttribute("showingSchedule", showingSchedule);
        return "estate/showing-schedule/show";
    }
}
