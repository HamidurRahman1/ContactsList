package com.hamidur.cunyfirst.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    @RequestMapping("/c")
    public String home2()
    {
        return "test";
    }
}
