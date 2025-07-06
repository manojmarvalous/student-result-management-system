package com.srms.service;

import com.srms.entity.Admin;
import com.srms.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByUsername(username);
        if (admin == null) throw new UsernameNotFoundException("User not found");

        return new User(admin.getUsername(), admin.getPassword(), Collections.emptyList());
    }
}
