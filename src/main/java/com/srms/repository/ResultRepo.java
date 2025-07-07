package com.srms.repository;

import com.srms.entity.Result;
import com.srms.entity.Student;
import com.srms.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result, Long> {

    // Custom method to delete all results of a student
    void deleteByStudent(Student student);

    // (Optional) To view results of a student
    List<Result> findByStudent(Student student);
    
    void deleteByStudentAndSubject(Student student, Subject subject);

}
