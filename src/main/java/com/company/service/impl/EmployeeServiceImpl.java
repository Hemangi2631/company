package com.company.service.impl;

import com.company.dto.EmployeeDTO;
import com.company.entity.EmployeeEntity;
import com.company.repository.EmployeeEntityRepository;
import com.company.service.EmployeeService;
import com.company.transformer.EmployeeTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeEntityRepository repository;
    private final EmployeeTransformer transformer;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return repository.findAll()
                .stream()
                .map(transformer::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByDepartmentId(String departmentId) {
        return repository.findByDepartmentId(departmentId)
                .stream()
                .map(employeeEntity -> transformer.toDTO(employeeEntity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = transformer.toEntity(employeeDTO);
        EmployeeEntity save = repository.save(entity);
        return transformer.toDTO(save);
    }

    @Override
    public void deleteEmployeeByDepartment(String departmentId, String employedId) {
        repository.deleteByDepartmentIdAndId(departmentId, employedId);
    }

    @Override
    public void deleteEmployeeByDepartment(String employedId) {
        repository.deleteAllById(Collections.singleton(employedId));
    }
}