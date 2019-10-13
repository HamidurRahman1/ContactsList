package com.hamidur.cunyfirst.models.generalModels;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

public class Student
{
    private Integer studentId;
	private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String ssn;

    @Autowired
    private Address address;
    @Autowired
    private Contact contact;
    @Autowired
    private HighSchoolInfo highSchoolInfo;
    @Autowired
    private TransferInfo transferInfo;
    @Autowired
    private Login login;

    @Autowired
    private Set<SecurityQuestionAnswer> questionAnswers;
    @Autowired
    private Set<FAFSA> fafsas;

    public Student() {}

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public HighSchoolInfo getHighSchoolInfo() {
        return highSchoolInfo;
    }

    public void setHighSchoolInfo(HighSchoolInfo highSchoolInfo) {
        this.highSchoolInfo = highSchoolInfo;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public void setTransferInfo(TransferInfo transferInfo) {
        this.transferInfo = transferInfo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Set<SecurityQuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Set<SecurityQuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public Set<FAFSA> getFafsas() {
        return fafsas;
    }

    public void setFafsas(Set<FAFSA> fafsas) {
        this.fafsas = fafsas;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", ssn='" + ssn + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                ", highSchoolInfo=" + highSchoolInfo +
                ", login=" + login +
                ", questionAnswers=" + questionAnswers +
                ", fafsas=" + fafsas +
                '}';
    }
}
