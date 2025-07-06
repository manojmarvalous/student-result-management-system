package com.srms.service;

import com.srms.entity.ClassEntity;
import com.srms.repository.ClassRepo;
import com.srms.repository.SubjectCombinationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepo classRepo;
    
    @Autowired
    private SubjectCombinationRepo subjectCombinationRepo;

    public List<ClassEntity> getAllClasses() {
        return classRepo.findAll();
    }

    public void saveClass(ClassEntity classEntity) {
        classRepo.save(classEntity);
    }

    public ClassEntity getClassById(Long id) {
        return classRepo.findById(id).orElse(null);
    }

    public void deleteClass(Long id) {
        if (subjectCombinationRepo.existsByClassEntityId(id)) {
            throw new RuntimeException("Cannot delete class — it is assigned to one or more subject combinations.");
        }

        classRepo.deleteById(id);
    }

}
