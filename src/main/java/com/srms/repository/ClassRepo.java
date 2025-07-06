package com.srms.repository;

import com.srms.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepo extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassName(String className);
}
