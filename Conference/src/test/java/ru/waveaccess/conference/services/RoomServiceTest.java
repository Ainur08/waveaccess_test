package ru.waveaccess.conference.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.waveaccess.conference.dto.RoomDto;
import ru.waveaccess.conference.models.Room;
import ru.waveaccess.conference.repositories.RoomRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void getAllRoom() {
        Room room = Room.builder()
                .id(1L)
                .number("11-800")
                .build();
        Room room2 = Room.builder()
                .id(2L)
                .number("11-801")
                .build();
        Room room3 = Room.builder()
                .id(3L)
                .number("11-802")
                .build();
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room2);
        rooms.add(room3);
        roomRepository.saveAll(rooms);

        List<RoomDto> savedRooms = roomService.findAllRoom();
        assertEquals(RoomDto.from(rooms).get(0).getNumber(), savedRooms.get(0).getNumber());
    }
}
