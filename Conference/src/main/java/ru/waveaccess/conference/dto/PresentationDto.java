package ru.waveaccess.conference.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.waveaccess.conference.models.Presentation;
import ru.waveaccess.conference.models.Schedule;
import ru.waveaccess.conference.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresentationDto {
    private Long id;
    private String name;
    private List<User> users;

    public static PresentationDto from(Presentation presentation) {
        return PresentationDto.builder()
                .id(presentation.getId())
                .name(presentation.getName())
                .users(presentation.getUsers())
                .build();
    }

    public static List<PresentationDto> from(List<Presentation> presentations) {
        return presentations.stream()
                .map(PresentationDto::from)
                .collect(Collectors.toList());
    }
}
