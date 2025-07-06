package com.srms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "admin/login"; // ✅ this should match your template path
    }
    
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
    

}
