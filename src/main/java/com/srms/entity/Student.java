package com.srms.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private String rollNo;

    private String name;

    @ManyToOne
    private ClassEntity studentClass;

    private String year;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassEntity getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(ClassEntity studentClass) {
		this.studentClass = studentClass;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
    
}

