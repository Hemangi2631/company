package com.company.transformer;

import com.company.dto.EmployeeDTO;
import com.company.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransformer {

    public EmployeeDTO toDTO(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPosition(entity.getPosition());
        dto.setSalary(entity.getSalary());
        dto.setDepartmentId(entity.getDepartmentId());
        return dto;
    }

    public EmployeeEntity toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPosition(dto.getPosition());
        entity.setSalary(dto.getSalary());
        entity.setDepartmentId(dto.getDepartmentId());
        return entity;
    }
}
