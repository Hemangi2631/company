package com.company.service.impl;
import com.company.service.ReportService;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import java.io.ByteArrayOutputStream;


@Log4j2
@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public byte[] generateReport(String reportPath, Map<String, Object> parameters, List<?> data) throws JRException {
        try {
            // Load the JRXML file from classpath
            InputStream inputStream = new ClassPathResource("reports/employeeReport.jrxml").getInputStream();

            // Compile the report
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(data));

            // Export the report to PDF
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            log.error("Exception acured while genarating report. Error Message: {}", e.getMessage(), e);
            //  throw new JRException("Error generating report", e);
        }
        return new byte[0];
    }
}