package com.srms.util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.srms.entity.Result;
import com.srms.entity.Student;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PdfGenerator {

    public void generateStudentResultPdf(HttpServletResponse response, Student student, List<Result> results, int total) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph title = new Paragraph("Student Result", titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));

        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
        document.add(new Paragraph("Name: " + student.getName(), infoFont));
        document.add(new Paragraph("Roll No: " + student.getRollNo(), infoFont));
        document.add(new Paragraph("Class: " + student.getStudentClass().getClassName(), infoFont));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell("Subject");
        table.addCell("Marks");

        for (Result r : results) {
            table.addCell(r.getSubject().getSubjectName());
            table.addCell(String.valueOf(r.getMarks()));
        }

        table.addCell("Total");
        table.addCell(String.valueOf(total));

        document.add(table);
        document.close();
    }
}
