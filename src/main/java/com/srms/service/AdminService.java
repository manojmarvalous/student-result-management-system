package com.srms.service;

import com.srms.entity.Admin;
import com.srms.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired private AdminRepo adminRepo;

    public Admin getByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    public void updatePassword(String username, String encodedPassword) {
        Admin admin = adminRepo.findByUsername(username);
        admin.setPassword(encodedPassword);
        adminRepo.save(admin);
    }
    
    

}
