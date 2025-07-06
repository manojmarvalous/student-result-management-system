package com.srms.controller;

import com.srms.entity.Student;
import com.srms.service.ClassService;
import com.srms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("pageTitle", "Manage Students");
        return "admin/manage_students";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("pageTitle", "Register Student");
        return "admin/student_form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/admin/students";
    }

    @GetMapping("/edit/{rollNo}")
    public String editStudent(@PathVariable String rollNo, Model model) {
        model.addAttribute("student", studentService.getStudentByRollNo(rollNo));
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("pageTitle", "Edit Student");
        return "admin/student_form";
    }

    @GetMapping("/delete/{rollNo}")
    public String deleteStudent(@PathVariable String rollNo) {
        studentService.deleteStudent(rollNo);
        return "redirect:/admin/students";
    }
}
