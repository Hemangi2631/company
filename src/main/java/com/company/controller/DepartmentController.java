package com.company.controller;

import com.company.entity.DepartmentEntity;
import com.company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/")
    public List<DepartmentEntity> getAllDepartments() {
        log.debug("Inside getAllDepartments");
        return departmentService.getAllDepartments();
    }

//    @GetMapping("/{id}")
//    public Optional<Department> getDepartmentById(@PathVariable Long id) {
//        return departmentService.getDepartmentById(id);
//    }
}