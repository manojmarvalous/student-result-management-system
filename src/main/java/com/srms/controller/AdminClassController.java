package com.srms.controller;

import com.srms.entity.ClassEntity;
import com.srms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/classes")
public class AdminClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("pageTitle", "Manage Classes");
        return "admin/manage_classes";
    }

    @GetMapping("/add")
    public String addClassForm(Model model) {
        model.addAttribute("classEntity", new ClassEntity());
        model.addAttribute("pageTitle", "Add New Class");
        return "admin/class_form";
    }

    @PostMapping("/save")
    public String saveClass(@ModelAttribute("classEntity") ClassEntity classEntity) {
        classService.saveClass(classEntity);
        return "redirect:/admin/classes";
    }

    @GetMapping("/edit/{id}")
    public String editClass(@PathVariable Long id, Model model) {
        ClassEntity classEntity = classService.getClassById(id);
        model.addAttribute("classEntity", classEntity);
        model.addAttribute("pageTitle", "Edit Class");
        return "admin/class_form";
    }

 // ClassController.java
    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            classService.deleteClass(id);
            redirectAttributes.addFlashAttribute("message", "✅ Class deleted successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage()); // show reason
        }
        return "redirect:/admin/classes";
    }


}
