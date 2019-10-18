package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentService
{
    public StudentService() {}
    
    public void insertStudent(com.hamidur.cunyfirst.viewTier.models.Student student)
    {
    
    }
    
    public void getStudent(Integer studentId) {}
    
    public void getStudents() {}
    
    public void updateStudent(com.hamidur.cunyfirst.viewTier.models.Student student) {}
    
    public void deleteStudent(com.hamidur.cunyfirst.viewTier.models.Student student) {}
    
    public void insertStudentAddress(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Address address) {}
    
    public void getStudentAddress(Integer studentId) {}
    
    public void updateStudentAddress(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Address address) {}
    
    public void insertStudentContact(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Contact contact) {}
    
    public void getStudentContact(Integer studentId) {}
    
    public void updateStudentContact(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {}
    
    public void insertStudentHighSchoolInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo highSchoolInfo)
    {}
    
    public void getStudentHighSchoolInfo(Integer studentId)
    {}
    
    public void updateStudentHighSchoolInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo highSchoolInfo) {}
    
    public void insertStudentTransferInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo) {}
    
    public void getStudentTransferInfo(Integer studentId)
    {}
    
    public void updateStudentTransferInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo)
    {}
    
    public void validateLogin(String username, String password)
    {}
    
    public void updateStudentPassword(Integer studentId, String newPassword)
    {}
    
    public void insertStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void getStudentSecurityQuestions(Integer studentId) {}
    
    public void updateStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void insertStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public void getStudentFafsas(Integer studentId) {}
    
    public void updateStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public void insertStudentCourses(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.Course> courses) {}
    
    public void getStudentCourses(Integer studentId) {}

    public void getStudentById(Integer studentId) {}
    public void getStudentBySSN(String ssn) {}
    public void getStudentByLogin(String userName, String password) {}

    public boolean isExists(Integer studentId) {return false;}
    public boolean isExists(String ssn) {return false;}
    public boolean isLoginExists(String userName) {return false;}

    public List<com.hamidur.cunyfirst.viewTier.models.Student> getAllStudents() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCourses() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCoursesByTerm
            (com.hamidur.cunyfirst.viewTier.models.Term term)
    {return new LinkedList<>();}
    
    private void toViewStudent(Student student) {}
    
    private void toViewAddress(Address address) {}
    
    private void toViewContact(Contact contact) {}
    
    private void toViewHighSchoolInfo(HighSchoolInfo highSchoolInfo) {}
    
    private void toViewTransferInfo(TransferInfo transferInfo) {}
    
    private void toViewLogin(Login login) {}
}
