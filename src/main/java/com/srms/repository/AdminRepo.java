package com.srms.repository;

//package com.srms.repository;

import com.srms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);  // For login
}

