package ru.waveaccess.conference.services;

import ru.waveaccess.conference.dto.ScheduleDto;
import ru.waveaccess.conference.dto.ScheduleHelperDto;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> findAllSchedule();
    void createSchedule(ScheduleHelperDto scheduleHelperDto);
    List<ScheduleDto> findByRoom(String num);
}
