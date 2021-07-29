package com.spring.car_dealership_IS.controller;

import com.spring.car_dealership_IS.servicees.MarkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MarkControllerTest {

    @Mock
    MarkService markService;

    @InjectMocks
    MarkController markController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(markController).build();
    }

    @Test
    void isMarkUrlIsWorking() throws Exception {
        mockMvc.perform(get("/api/marks"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void showAllMarks() {
    }
}