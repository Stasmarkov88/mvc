package com.spring.controllers;

import com.spring.domain.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult, RedirectAttributes model) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        userRepository.save(user);
        model.addAttribute("login", user.getLogin());
        model.addFlashAttribute("user", user);
        return "redirect:/user/{login}";
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
