package com.hamidur.cunyfirst.viewTier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController
{
    public String studentLogin()
    {
        return "login";
    }
}
