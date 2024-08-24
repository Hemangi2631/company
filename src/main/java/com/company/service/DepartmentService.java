package com.company.service;

import com.company.dto.DepartmentDTO;
import com.company.entity.DepartmentEntity;


import java.util.List;

public interface DepartmentService {

	List<DepartmentDTO> getAllDepartments();
}