package com.company.service;

import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {

    byte[] generateReport(String reportTemplatePath, Map<String, Object> parameters, List<?> dataSource) throws JRException;
}
