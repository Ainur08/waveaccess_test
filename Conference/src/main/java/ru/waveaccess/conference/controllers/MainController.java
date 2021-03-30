package ru.waveaccess.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.waveaccess.conference.services.RoomService;
import ru.waveaccess.conference.services.ScheduleService;

@Controller
public class MainController implements WebMvcConfigurer {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/main")
    public String listOfSchedule(Model model) {
        model.addAttribute("schedules", scheduleService.findAllSchedule());
        model.addAttribute("rooms", roomService.findAllRoom());
        return "main";
    }
}
