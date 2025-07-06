package com.srms.service;

import com.srms.entity.Result;
import com.srms.entity.Student;
import com.srms.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepo resultRepo;

    public List<Result> getResultsByStudent(Student student) {
        return resultRepo.findByStudent(student);
    }

    public void saveAll(List<Result> results) {
        resultRepo.saveAll(results);
    }
    
    public int getTotalMarks(List<Result> results) {
        return results.stream().mapToInt(Result::getMarks).sum();
    }

}
