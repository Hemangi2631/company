package com.company.controller;

import com.company.entity.EmployeeEntity;
import com.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployee() {
        log.debug("Inside getAllEmployee");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{departmentId}")
    public List<EmployeeEntity> getDepartmentById(@PathVariable String departmentId) {
        return employeeService.findByDepartmentId(departmentId);
    }

    @PostMapping("/employee")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createEmployee(employeeEntity);
    }

    @DeleteMapping("/department/{departmentId}/employee/{employedId}")
    public void deleteEmployeeByDepartment(@PathVariable String departmentId, @PathVariable String employedId) {
        employeeService.deleteEmployeeByDepartment(departmentId, employedId);
    }

}