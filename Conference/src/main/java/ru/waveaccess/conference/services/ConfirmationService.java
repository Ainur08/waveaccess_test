package ru.waveaccess.conference.services;

import ru.waveaccess.conference.dto.EmailDto;

public interface ConfirmationService {
    void send(EmailDto emailDto);
    void checkConfirmation(String token);
}
