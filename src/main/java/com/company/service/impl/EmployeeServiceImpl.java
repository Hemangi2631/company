package com.company.service.impl;

import com.company.entity.EmployeeEntity;
import com.company.repository.EmployeeEntityRepository;
import com.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeEntityRepository repository;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public List<EmployeeEntity> findByDepartmentId(String departmentId) {
        return repository.findByDepartmentId(departmentId);
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return repository.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeByDepartment(String departmentId, String employedId) {
        repository.deleteByDepartmentIdAndId(departmentId, employedId);
    }

    @Override
    public DataTablesOutput<EmployeeEntity> dataTable(DataTablesInput dataTablesInput) {
        return repository.findAll(dataTablesInput);
    }
}