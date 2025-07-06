package com.srms.service;

import com.srms.entity.Student;
import com.srms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStudentByRollNo(String rollNo) {
        return studentRepo.findById(rollNo).orElse(null);
    }

    public void deleteStudent(String rollNo) {
        studentRepo.deleteById(rollNo);
    }
}
