package com.company.service;

import com.company.dto.EmployeeDTO;
import com.company.entity.EmployeeEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployee();

	List<EmployeeDTO> findByDepartmentId(String departmentId);

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

	void deleteEmployeeByDepartment(String departmentId, String employedId);

	void deleteEmployeeByDepartment(String employedId);
}