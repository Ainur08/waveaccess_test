package ru.waveaccess.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.waveaccess.conference.dto.ScheduleDto;
import ru.waveaccess.conference.dto.ScheduleHelperDto;
import ru.waveaccess.conference.models.Schedule;
import ru.waveaccess.conference.repositories.PresentationRepository;
import ru.waveaccess.conference.repositories.RoomRepository;
import ru.waveaccess.conference.repositories.ScheduleRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PresentationRepository presentationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<ScheduleDto> findAllSchedule() {
        return ScheduleDto.from(scheduleRepository.findAll());
    }

    @Override
    @Transactional
    public void createSchedule(ScheduleHelperDto scheduleHelperDto) {
        Schedule schedule = Schedule.builder()
                .id(scheduleHelperDto.getId())
                .startTime(Timestamp.valueOf(scheduleHelperDto.getStartTime()))
                .endTime(Timestamp.valueOf(scheduleHelperDto.getEndTime()))
                .presentation(presentationRepository.findById(scheduleHelperDto.getPresentationId()).get())
                .room(roomRepository.findByNumber(scheduleHelperDto.getRoomNumber()).get())
                .build();

        if (schedule.getStartTime().before(schedule.getEndTime())) {
            List<Schedule> schedulesWithThisRoom = scheduleRepository.findByRoom(schedule.getRoom().getNumber());
            Timestamp startTime = schedule.getStartTime();
            Timestamp endTime = schedule.getEndTime();

            if (schedulesWithThisRoom.stream().allMatch(s -> (endTime.before(s.getStartTime()) && s.getEndTime().before(startTime)))) {
                scheduleRepository.save(schedule);
            }
        }
    }

    @Override
    public List<ScheduleDto> findByRoom(String num) {
        return ScheduleDto.from(scheduleRepository.findByRoom(num));
    }
}
