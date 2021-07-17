package com.spring.car_dealership_IS.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class startPageTest {

    @InjectMocks
    MainController  mainController;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void index() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /*
      @Test
    void getDataFromIndexPage(){
        //given
        Long id = 1L;
        String name = "Igor";
        String password = "qwerty";

        List<User> users = new ArrayList<>();
        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        users.add(user);
        when(userService.findAll()).thenReturn(users);

        ArgumentCaptor<List<User>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //when
        String viewName = controller.getIndexPage(model);

        //then
        verify(userService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("rs"), argumentCaptor.capture());
        List<User> setInController = argumentCaptor.getValue();
        assertEquals(1, setInController.size());
        assertEquals(setInController.get(0).getName(), name);

    }
     */
}