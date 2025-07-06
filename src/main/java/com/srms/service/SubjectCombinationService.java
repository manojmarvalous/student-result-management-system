package com.srms.service;

import com.srms.entity.SubjectCombination;
import com.srms.repository.SubjectCombinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectCombinationService {

    @Autowired
    private SubjectCombinationRepo subjectCombinationRepo;

    public List<SubjectCombination> getAll() {
        return subjectCombinationRepo.findAll();
    }

    public void save(SubjectCombination combination) {
        subjectCombinationRepo.save(combination);
    }

    public SubjectCombination getById(Long id) {
        return subjectCombinationRepo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        subjectCombinationRepo.deleteById(id);
    }
}
