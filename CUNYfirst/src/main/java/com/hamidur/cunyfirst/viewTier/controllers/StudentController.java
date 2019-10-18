package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @RequestMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("studentLogin", new Login());
        return "student/login";
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("studentLogin") Login login)
    {
        // validate login
        System.out.println(login.getUsername());
        System.out.println(login.getPassword());
        return "student/display";
    }
}
