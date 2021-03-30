package ru.waveaccess.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.waveaccess.conference.dto.PresentationDto;
import ru.waveaccess.conference.dto.ScheduleDto;
import ru.waveaccess.conference.dto.ScheduleHelperDto;
import ru.waveaccess.conference.models.User;
import ru.waveaccess.conference.security.details.UserDetailsImpl;
import ru.waveaccess.conference.services.PresentationService;
import ru.waveaccess.conference.services.ScheduleService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PresentationController {
    @Autowired
    private PresentationService presentationService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/presentation")
    public String listOfLecture(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("presentations", presentationService.findAllPresentationByUser(userDetails.getUser()));
        return "presentation";
    }

    @PostMapping("/presentation/schedule")
    public String createSchedule(ScheduleHelperDto scheduleHelperDto) {
        System.out.println(scheduleHelperDto.getPresentationId());
        System.out.println(scheduleHelperDto.getRoomNumber());
        scheduleService.createSchedule(scheduleHelperDto);
        return "redirect:/presentation";
    }

    @PostMapping("/presentation")
    public String createPresentation(PresentationDto presentationDto, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<User> userList = new ArrayList<>();
        userList.add(userDetails.getUser());
        presentationDto.setUsers(userList);

        presentationService.createPresentation(presentationDto);
        return "redirect:/presentation";
    }

    @PostMapping("/presentation/update/{id}")
    public String updateName(@PathVariable Long id, @RequestParam String name) {
        presentationService.updateName(id, name);
        return "redirect:/presentation";
    }
}
