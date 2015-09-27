package com.spring.controllers;

import com.spring.config.RootConfig;
import com.spring.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RegisterControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testShowRegister() throws Exception {
        RegisterController controller = new RegisterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/register")).andExpect(view().name("registerForm"));
    }
}