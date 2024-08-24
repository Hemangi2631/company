package com.company.service.impl;

import com.company.dto.DepartmentDTO;
import com.company.entity.DepartmentEntity;
import com.company.repository.DepartmentEntityRepository;
import com.company.service.DepartmentService;
import com.company.transformer.DepartmentTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentEntityRepository repository;
    private final DepartmentTransformer transformer;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(transformer::toDTO)
                .collect(Collectors.toList());
    }
}