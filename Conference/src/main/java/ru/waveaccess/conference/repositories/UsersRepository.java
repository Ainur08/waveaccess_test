package ru.waveaccess.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.waveaccess.conference.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);

    @Modifying
    @Query(value = "update User u set u.name = ?1, u.email = ?2 where u.id = ?3")
    void updateNameAndEmail(String name, String email, Long id);
}
