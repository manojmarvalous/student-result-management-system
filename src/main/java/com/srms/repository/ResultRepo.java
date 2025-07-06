package com.srms.repository;

import com.srms.entity.Result;
import com.srms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result, Long> {
    List<Result> findByStudent(Student student);
}
