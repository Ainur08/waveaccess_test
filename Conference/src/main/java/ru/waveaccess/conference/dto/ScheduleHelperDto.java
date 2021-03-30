package ru.waveaccess.conference.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleHelperDto {
    private Long id;
    private String startTime;
    private String endTime;
    private String roomNumber;
    private Long presentationId;
}
