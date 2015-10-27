package com.spring.handlers;

import com.spring.domain.User;
import com.spring.exceptions.AccessDeniedException;
import com.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Controller
public class AppWideExceptionHandler {

    @Autowired
    private UserService userService;

    @ExceptionHandler(AccessDeniedException.class)
    public String handle403 (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByLogin(authentication.getName());
        model.addAttribute("user", user);
        return "403";
    }

//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public String accessDenied(ModelMap model, Principal principal) {
//        String username = principal.getName();
//        model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
//        return "403";
//    }
}
