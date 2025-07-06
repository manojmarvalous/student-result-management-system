package com.srms.controller;

import com.srms.entity.Result;
import com.srms.entity.Student;
import com.srms.service.ResultService;
import com.srms.service.StudentService;
import com.srms.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("/student")
public class StudentResultController {

    @Autowired private StudentService studentService;
    @Autowired private ResultService resultService;
    @Autowired private PdfGenerator pdfGenerator;

    // Show result form
    @GetMapping("/result")
    public String resultForm() {
        return "student/result_form";
    }

    // View result
    @PostMapping("/result/view")
    public String viewResult(@RequestParam String rollNo, Model model) {
        Student student = studentService.getStudentByRollNo(rollNo);
        if (student == null) {
            model.addAttribute("error", "Roll number not found.");
            return "student/result_form";
        }

        List<Result> results = resultService.getResultsByStudent(student);
        int total = resultService.getTotalMarks(results);

        model.addAttribute("student", student);
        model.addAttribute("results", results);
        model.addAttribute("total", total);

        return "student/result_view";
    }

    // Download PDF
    @GetMapping("/result/pdf/{rollNo}")
    public void downloadPdf(@PathVariable String rollNo, HttpServletResponse response) throws IOException {
        Student student = studentService.getStudentByRollNo(rollNo);
        List<Result> results = resultService.getResultsByStudent(student);
        int total = resultService.getTotalMarks(results);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=result_" + rollNo + ".pdf");

        pdfGenerator.generateStudentResultPdf(response, student, results, total);
    }
}
