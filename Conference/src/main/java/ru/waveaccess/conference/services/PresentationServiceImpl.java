package ru.waveaccess.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.waveaccess.conference.dto.PresentationDto;
import ru.waveaccess.conference.models.Presentation;
import ru.waveaccess.conference.models.User;
import ru.waveaccess.conference.repositories.PresentationRepository;
import java.util.List;

@Service
public class PresentationServiceImpl implements PresentationService {
    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public List<PresentationDto> findAllPresentationByUser(User user) {
        return PresentationDto.from(presentationRepository.findByUsers(user));
    }

    @Override
    public void createPresentation(PresentationDto presentationDto) {
        presentationRepository.save(Presentation.builder()
                .name(presentationDto.getName())
                .users(presentationDto.getUsers())
                .build());
    }

    @Override
    @Transactional
    public void updateName(Long id, String name) {
        presentationRepository.updateName(name, id);
    }
}
