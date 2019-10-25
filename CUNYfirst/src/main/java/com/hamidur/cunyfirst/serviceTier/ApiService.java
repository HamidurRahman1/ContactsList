package com.hamidur.cunyfirst.serviceTier;

import com.hamidur.cunyfirst.daoTier.daoServices.AdminService;
import com.hamidur.cunyfirst.daoTier.daoServices.CourseService;
import com.hamidur.cunyfirst.daoTier.daoServices.InstructorService;
import com.hamidur.cunyfirst.daoTier.daoServices.StudentService;

public class ApiService
{
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final CourseService courseService;
    private final AdminService adminService;

    public ApiService(final StudentService studentService, final InstructorService instructorService,
                      final CourseService courseService, final AdminService adminService)
    {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.adminService = adminService;
    }
}
