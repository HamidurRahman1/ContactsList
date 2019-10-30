package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.serviceTier.ApiService;
import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Login;

import com.hamidur.cunyfirst.viewTier.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController
{
    private final ApplicationContext applicationContext;
    private final ApiService apiService;


    public StudentController(final ApplicationContext applicationContext, final ApiService apiService)
    {
        this.applicationContext = applicationContext;
        this.apiService = apiService;
    }

    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", applicationContext.getBean(Login.class));
        return "student/login";
    }

    /*
    * this url will be called after the submission of login. Login form has a Login() attribute which can only
    * be accessible in services.jsp if this method takes Login object from/as @ModelAttribute, which will then be
    * available to access in services.jsp
    * */
    @PostMapping("/processLogin")
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session)
    {
//        session.setAttribute("login", login);
        Student student = ViewRelatedTester.testStudent();
        session.setAttribute("student", student);
        return "redirect:/student/display";
    }

    @GetMapping("/display")
    public String displayStudent()
    {
        return "student/display";
    }


}
