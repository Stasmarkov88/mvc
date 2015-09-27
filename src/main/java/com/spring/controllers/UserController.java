package com.spring.controllers;

import com.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @RequestMapping(value = "/{login}",method = RequestMethod.GET)
    public String profile(User user, Model model){
        model.addAttribute("user", user);
        return "user";
    }
}
