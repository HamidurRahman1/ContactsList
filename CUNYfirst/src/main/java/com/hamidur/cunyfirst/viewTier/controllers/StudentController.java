package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.models.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @GetMapping("/login")
    public ModelAndView studentLogin()
    {
        ModelAndView modelAndView = new ModelAndView("student/login");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }

    @PostMapping("/processLogin")
    public ModelAndView processLogin(@ModelAttribute("login") Login login)
    {
        ModelAndView modelAndView = new ModelAndView("student/display");
        modelAndView.addObject("login", login);
        return modelAndView;
    }
}
