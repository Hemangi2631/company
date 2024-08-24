package com.company.transformer;

import com.company.dto.DataTableDTO;
import com.company.entity.DataTableEntity;
import org.springframework.stereotype.Component;

@Component
public class DataTableTransformer {

    public DataTableDTO toDTO(DataTableEntity entity) {
        if (entity == null) {
            return null;
        }
        DataTableDTO dto = new DataTableDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPosition(entity.getPosition());
        dto.setSalary(entity.getSalary());
        dto.setDepartmentId(entity.getDepartmentId());
        dto.setLocation(entity.getLocation());
        dto.setDepartmentName(entity.getDepartmentName());
        return dto;
    }

    public DataTableEntity toEntity(DataTableDTO dto) {
        if (dto == null) {
            return null;
        }
        DataTableEntity entity = new DataTableEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPosition(dto.getPosition());
        entity.setSalary(dto.getSalary());
        entity.setDepartmentId(dto.getDepartmentId());
        entity.setLocation(dto.getLocation());
        entity.setDepartmentName(dto.getDepartmentName());
        return entity;
    }
}