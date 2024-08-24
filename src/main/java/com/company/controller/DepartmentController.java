package com.company.controller;

import com.company.dto.DepartmentDTO;
import com.company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/")
    public List<DepartmentDTO> getAllDepartments() {
        log.debug("Inside getAllDepartments");
        return departmentService.getAllDepartments();
    }
}