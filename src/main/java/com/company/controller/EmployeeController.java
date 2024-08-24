package com.company.controller;

import com.company.dto.EmployeeDTO;
import com.company.entity.EmployeeEntity;
import com.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
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
    public List<EmployeeDTO> getAllEmployee() {
        log.debug("Inside getAllEmployee");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{departmentId}")
    public List<EmployeeDTO> getDepartmentById(@PathVariable String departmentId) {
        return employeeService.findByDepartmentId(departmentId);
    }

    @PostMapping("/employee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping("/department/{departmentId}/employee/{employedId}")
    public void deleteEmployeeByDepartment(@PathVariable String departmentId, @PathVariable String employedId) {
        employeeService.deleteEmployeeByDepartment(departmentId, employedId);
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updated = employeeService.createEmployee(employeeDTO);
        if (updated != null) {
            return ResponseEntity.ok("Employee updated successfully");
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    @DeleteMapping("/deleteEmployee/{employedId}")
    public void deleteEmployee(@PathVariable String employedId) {
        employeeService.deleteEmployeeByDepartment(employedId);
    }
}