package ru.waveaccess.conference.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.waveaccess.conference.controllers.rest.ScheduleRestController;
import ru.waveaccess.conference.dto.ScheduleDto;
import ru.waveaccess.conference.models.Room;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ScheduleRestControllerTest {
    private MockMvc mockMvc;

    @MockBean
    private ScheduleRestController scheduleRestController;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleRestController).build();
        when(scheduleRestController.getScheduleByRoom("11-800")).thenReturn(getScheduleDtoList());
    }

    @Test
    public void getScheduleByRoomNumberTest() throws Exception {
        mockMvc.perform(get("/api/schedule/room/11-800")).andDo(print())
                .andExpect(status().isOk());
    }


    private List<ScheduleDto> getScheduleDtoList(){
        return Collections.singletonList(ScheduleDto.builder()
                .room(Room.builder()
                        .id(1L)
                        .number("11-800")
                        .build())
                .build());
    }
}
