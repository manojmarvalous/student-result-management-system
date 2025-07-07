package com.srms.service;

import org.springframework.transaction.annotation.Transactional;

import com.srms.entity.Student;
import com.srms.repository.ResultRepo;
import com.srms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    
    @Autowired
    private ResultRepo resultRepository;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStudentByRollNo(String rollNo) {
        return studentRepo.findById(rollNo).orElse(null);
    }
    @Transactional 
    public void deleteStudent(String rollNo) {
        Student student = getStudentByRollNo(rollNo);
        if (student != null) {
            // ✅ Delete results first
            resultRepository.deleteByStudent(student);

            // ✅ Now delete student
            studentRepo.deleteById(rollNo);
        }
    }
}
