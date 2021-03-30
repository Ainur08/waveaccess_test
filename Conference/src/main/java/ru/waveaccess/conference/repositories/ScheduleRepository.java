package ru.waveaccess.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.waveaccess.conference.models.Schedule;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Modifying
    @Query("SELECT u FROM Schedule u where u.room.number = ?1")
    List<Schedule> findByRoom(String num);
}
