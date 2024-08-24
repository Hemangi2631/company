package com.company.controller;

import com.company.dto.EmployeeDTO;
import com.company.entity.EmployeeEntity;
import com.company.service.EmployeeService;
import com.company.service.ReportService;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmployeeService employeeService; // Service to fetch employee data

    @GetMapping("/employeeReport")
    public ResponseEntity<byte[]> getEmployeeReport() {
        log.debug("Inside getEmployeeReport");
        try {
            // Path to the JRXML template (make sure it's in the resources folder)
            String reportPath = "classpath:employeeReport.jrxml";

            // Parameters for the report (if any)
            Map<String, Object> parameters = new HashMap<>();
            // Add any report parameters here if needed

            // Fetch data for the report
            List<EmployeeDTO> employees = employeeService.getAllEmployee();

            // Generate the report
            byte[] report = reportService.generateReport(reportPath, parameters, employees);

            // Set the response headers for PDF download
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "EmployeeReport.pdf");

            // Return the report as a PDF in the response body
            return ResponseEntity.ok().headers(headers).body(report);

        } catch (JRException e) {
            log.error("Error generating report", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}