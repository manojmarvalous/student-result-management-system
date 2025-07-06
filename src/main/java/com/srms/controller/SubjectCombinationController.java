package com.srms.controller;

import com.srms.entity.SubjectCombination;
import com.srms.service.ClassService;
import com.srms.service.SubjectCombinationService;
import com.srms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/subject-combinations")
public class SubjectCombinationController {

    @Autowired
    private SubjectCombinationService subjectCombinationService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String listCombinations(Model model) {
        model.addAttribute("combinations", subjectCombinationService.getAll());
        model.addAttribute("pageTitle", "Manage Subject Combinations");
        return "admin/manage_combinations";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("combination", new SubjectCombination());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("pageTitle", "Add Subject Combination");
        return "admin/combination_form";
    }

    @PostMapping("/save")
    public String saveCombination(@ModelAttribute SubjectCombination combination) {
        subjectCombinationService.save(combination);
        return "redirect:/admin/subject-combinations";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("combination", subjectCombinationService.getById(id));
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("pageTitle", "Edit Combination");
        return "admin/combination_form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        subjectCombinationService.delete(id);
        return "redirect:/admin/subject-combinations";
    }
}
