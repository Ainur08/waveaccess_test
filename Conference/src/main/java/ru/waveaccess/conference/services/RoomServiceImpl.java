package ru.waveaccess.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.waveaccess.conference.dto.RoomDto;
import ru.waveaccess.conference.repositories.RoomRepository;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<RoomDto> findAllRoom() {
        return RoomDto.from(roomRepository.findAll());
    }
}
