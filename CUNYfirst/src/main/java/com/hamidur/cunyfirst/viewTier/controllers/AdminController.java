package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController
{

    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "admin/login";
    }

    @PostMapping("/processAdminLogin")
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session)
    {
        Admin admin = ViewRelatedTester.testAdmin();
        session.setAttribute("admin", admin);
        return "redirect:/admin/services";
    }

    @GetMapping("/services")
    public String displayStudent()
    {
        return "admin/services";
    }

    @GetMapping("/student/insertStudent")
    public String insertStudent(Model model)
    {
        model.addAttribute("newStudent", new Student());
        return "admin/insertStudent";
    }

    @PostMapping("/student/process")
    public String processNewStudent(@ModelAttribute("newStudent") Student student, Model model)
    {
        // insert into db then redirect if success else error
        System.out.println(student);
        System.out.println(student.getAddress());
        System.out.println(student.getContact());
        System.out.println(student.getHighSchoolInfo());
        model.addAttribute("id", 1001);
        return "/admin/studentAdded";
    }
}
