package ru.waveaccess.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.waveaccess.conference.models.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByNumber(String number);
}
