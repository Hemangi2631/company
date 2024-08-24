package com.company.controller;

import com.company.entity.DepartmentEntity;
import com.company.entity.EmployeeEntity;
import com.company.service.DepartmentService;
import com.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class NavigationController {

private final EmployeeService employeeService;

    @GetMapping("/dashboard")
    public String dashboard() {
        log.debug("Inside dashboard");
        return "views/dashboard";
    }

    @ResponseBody
    @PostMapping(value = "/datatable")
    public DataTablesOutput<EmployeeEntity> getDataTable(@RequestBody DataTablesInput input) {
        return employeeService.dataTable(input);
    }
}