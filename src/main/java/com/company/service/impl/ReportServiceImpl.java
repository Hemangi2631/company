package com.company.service.impl;

import com.company.service.ReportService;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@Log4j2
@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public byte[] generateReport(String reportPath, Map<String, Object> parameters, List<?> data) throws JRException {
        try {

            InputStream inputStream = new ClassPathResource("reports/employeeReport.jrxml").getInputStream();

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(data));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            log.error("Exception acured while genarating report. Error Message: {}", e.getMessage(), e);
        }
        return new byte[0];
    }
}