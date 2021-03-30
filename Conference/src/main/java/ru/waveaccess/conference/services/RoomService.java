package ru.waveaccess.conference.services;

import ru.waveaccess.conference.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> findAllRoom();
}
