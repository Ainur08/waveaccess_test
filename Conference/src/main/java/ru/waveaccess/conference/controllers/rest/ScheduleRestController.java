package ru.waveaccess.conference.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.waveaccess.conference.dto.ScheduleDto;
import ru.waveaccess.conference.services.ScheduleService;

import java.util.List;

@RestController
public class ScheduleRestController {
    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/api/schedule/room/{num}")
    public List<ScheduleDto> getScheduleByRoom(@PathVariable("num") String num) {
        return scheduleService.findByRoom(num);
    }
}
