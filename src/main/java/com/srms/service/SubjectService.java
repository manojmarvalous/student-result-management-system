package com.srms.service;

import com.srms.entity.Subject;
import com.srms.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    public void saveSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepo.findById(id).orElse(null);
    }

    public void deleteSubject(Long id) {
        subjectRepo.deleteById(id);
    }
}
