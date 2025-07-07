package com.srms.controller;

import com.srms.entity.*;
import com.srms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin/results")
public class ResultController {

    @Autowired private ClassService classService;
    @Autowired private StudentService studentService;
    @Autowired private SubjectCombinationService combinationService;
    @Autowired private ResultService resultService;

    // Step 1: Choose class and roll number
    @GetMapping
    public String selectStudent(Model model) {
        model.addAttribute("classes", classService.getAllClasses());
        return "admin/select_student_result";
    }

    // Step 2: Show form to enter marks
    @PostMapping("/enter")
    public String enterMarks(@RequestParam Long classId,
                             @RequestParam String rollNo,
                             Model model) {
        Student student = studentService.getStudentByRollNo(rollNo);
        if (student == null || !student.getStudentClass().getId().equals(classId)) {
            model.addAttribute("error", "Invalid Roll Number or Class.");
            return "admin/select_student_result";
        }

        List<SubjectCombination> combinations = combinationService
                .getAll()
                .stream()
                .filter(c -> c.getClassEntity().getId().equals(classId) && c.isActive())
                .toList();

        List<Result> results = resultService.getResultsByStudent(student);
        Map<Long, Integer> subjectMarks = new HashMap<>();
        for (Result r : results) {
            subjectMarks.put(r.getSubject().getId(), r.getMarks());
        }

        model.addAttribute("student", student);
        model.addAttribute("combinations", combinations);
        model.addAttribute("subjectMarks", subjectMarks);

        return "admin/enter_marks";
    }

    // Step 3: Save marks
    @PostMapping("/save")
    public String saveResults(@RequestParam String rollNo,
                              @RequestParam Map<String, String> allParams) {

        Student student = studentService.getStudentByRollNo(rollNo);
        List<Result> results = new ArrayList<>();

        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("subject_")) {
                Long subjectId = Long.parseLong(entry.getKey().replace("subject_", ""));
                String value = entry.getValue().trim();

                if (value.isEmpty()) continue;  // skip if marks not entered

                Integer marks;
                try {
                    marks = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    continue; // or log an error, skip invalid entry
                }


                Subject subject = new Subject();
                subject.setId(subjectId);

                Result result = new Result();
                result.setStudent(student);
                result.setSubject(subject);
                result.setMarks(marks);

                results.add(result);
            }
        }

        resultService.saveAll(results);
        return "redirect:/admin/results";
    }
}
