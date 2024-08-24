package com.company.service;

import com.company.entity.EmployeeEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface EmployeeService {

	List<EmployeeEntity> getAllEmployee();

	List<EmployeeEntity> findByDepartmentId(String departmentId);

	EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

	void deleteEmployeeByDepartment(String departmentId, String employedId);

	DataTablesOutput<EmployeeEntity> dataTable(DataTablesInput dataTablesInput);
}