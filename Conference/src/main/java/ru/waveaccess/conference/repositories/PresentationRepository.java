package ru.waveaccess.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.waveaccess.conference.models.Presentation;
import ru.waveaccess.conference.models.User;

import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {
    List<Presentation> findByUsers(User user);

    @Modifying
    @Query(value = "update Presentation u set u.name = ?1 where u.id = ?2")
    void updateName(String name, Long id);
}
