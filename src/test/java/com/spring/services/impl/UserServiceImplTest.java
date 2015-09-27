package com.spring.services.impl;

import com.spring.config.RootConfig;
import com.spring.domain.User;
import com.spring.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setPassword("password");
        user.setAge(25);
        user.setEmail("a@i.ua");
        user.setLogin("login");

        User saved = userService.save(user);
        System.out.println(saved.getId());
    }
}