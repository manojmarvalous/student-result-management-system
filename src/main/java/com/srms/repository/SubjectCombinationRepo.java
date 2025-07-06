package com.srms.repository;

import com.srms.entity.SubjectCombination;
import com.srms.entity.ClassEntity;
import com.srms.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectCombinationRepo extends JpaRepository<SubjectCombination, Long> {
    List<SubjectCombination> findByClassEntityAndActiveTrue(ClassEntity classEntity);
    List<SubjectCombination> findByClassEntity(ClassEntity classEntity);
    SubjectCombination findByClassEntityAndSubject(ClassEntity classEntity, Subject subject);
    boolean existsByClassEntityId(Long classId);
}
