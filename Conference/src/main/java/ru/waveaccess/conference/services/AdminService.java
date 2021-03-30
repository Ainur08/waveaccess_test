package ru.waveaccess.conference.services;

import ru.waveaccess.conference.dto.UserDto;

import java.util.List;

public interface AdminService {
    List<UserDto> findAllUser();

    void makePresenter(Long id);

    void deleteUser(Long id);

    void updateNameAndEmail(Long id, String name, String email);
}
