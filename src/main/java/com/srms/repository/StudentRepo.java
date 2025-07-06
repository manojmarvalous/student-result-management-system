package com.srms.repository;

import com.srms.entity.Student;
import com.srms.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, String> {
    List<Student> findByStudentClass(ClassEntity studentClass);
    Student findByRollNo(String rollNo);
}
