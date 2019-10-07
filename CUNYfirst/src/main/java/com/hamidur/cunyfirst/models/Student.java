package com.hamidur.cunyfirst.models;

import java.time.LocalDate;
import java.util.Set;

public class Student
{
    private Integer studentId;
	private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String ssn;

    private Address address;
    private Set<SecurityQuestionAnswer> questionAnswerSet;

}
