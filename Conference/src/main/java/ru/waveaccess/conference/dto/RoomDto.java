package ru.waveaccess.conference.dto;

import lombok.Builder;
import lombok.Data;
import ru.waveaccess.conference.models.Room;
import ru.waveaccess.conference.models.Schedule;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class RoomDto {
    private String number;
    private List<Schedule> schedules;

    public static RoomDto from(Room room) {
        return RoomDto.builder()
                .number(room.getNumber())
                .schedules(room.getSchedules())
                .build();
    }

    public static List<RoomDto> from(List<Room> rooms) {
        return rooms.stream()
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }
}
