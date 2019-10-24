package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.models.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "student/login";
    }


    /*
    * this url will be called after the submission of login. Login form has a Login() attribute which can only
    * be accessible in display.jsp if this method takes Login object from/as @ModelAttribute, which will then be
    * available to access in display.jsp
    * */
    @PostMapping("/processLogin")
    public String processLogin(@ModelAttribute("login") Login login, Model model)
    {
        model.addAttribute("test", "testmessage");

        // validate if correct then forward it to display
        // redirect if wrong username or password

        return "student/display";
    }
}
