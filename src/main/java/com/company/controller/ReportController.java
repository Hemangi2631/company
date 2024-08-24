package com.company.controller;

import com.company.dto.EmployeeDTO;
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

            String reportPath = "classpath:employeeReport.jrxml";

            Map<String, Object> parameters = new HashMap<>();

            List<EmployeeDTO> employees = employeeService.getAllEmployee();

            byte[] report = reportService.generateReport(reportPath, parameters, employees);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "EmployeeReport.pdf");

            return ResponseEntity.ok().headers(headers).body(report);

        } catch (JRException e) {
            log.error("Error generating report", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}