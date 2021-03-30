package ru.waveaccess.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.waveaccess.conference.models.Presentation;
import ru.waveaccess.conference.models.Room;
import ru.waveaccess.conference.models.Schedule;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ScheduleDto {
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Room room;
    private Presentation presentation;

    public static ScheduleDto from(Schedule schedule) {
        return ScheduleDto.builder()
                .id(schedule.getId())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .room(schedule.getRoom())
                .presentation(schedule.getPresentation())
                .build();
    }

    public static List<ScheduleDto> from(List<Schedule> schedules) {
        return schedules.stream()
                .map(ScheduleDto::from)
                .collect(Collectors.toList());
    }
}
