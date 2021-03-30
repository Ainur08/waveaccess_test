package ru.waveaccess.conference.services;

import ru.waveaccess.conference.dto.PresentationDto;
import ru.waveaccess.conference.models.User;
import java.util.List;

public interface PresentationService {
    List<PresentationDto> findAllPresentationByUser(User user);
    void createPresentation(PresentationDto presentationDto);
    void updateName(Long id, String name);
}
