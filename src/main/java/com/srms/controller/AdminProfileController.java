package com.srms.controller;

import com.srms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminProfileController {

    @Autowired private AdminService adminService;

    @GetMapping("/change-password")
    public String changePasswordForm() {
        return "admin/change_password";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/change-password")
    public String updatePassword(@RequestParam String currentPassword,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 Model model) {

        // Dynamically get logged-in admin username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        if ("manoj".equalsIgnoreCase(username)) {
            model.addAttribute("error", "❌ You are not allowed to change the default admin password.");
            return "admin/change_password";
        }

        String encodedPassword = adminService.getByUsername(username).getPassword();

        //  Match current password using encoder
        if (!passwordEncoder.matches(currentPassword, encodedPassword)) {
            model.addAttribute("error", "Current password is incorrect.");
            return "admin/change_password";
        }

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "New passwords do not match.");
            return "admin/change_password";
        }

        // Encode and save the new password
        adminService.updatePassword(username, passwordEncoder.encode(newPassword));
        model.addAttribute("message", "✅ Password updated successfully.");
        return "admin/change_password";
    }

}
