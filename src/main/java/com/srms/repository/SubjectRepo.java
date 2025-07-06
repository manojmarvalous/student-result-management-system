package com.srms.repository;

import com.srms.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findBySubjectName(String subjectName);
}
