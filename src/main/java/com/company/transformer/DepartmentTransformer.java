package com.company.transformer;

import com.company.dto.DepartmentDTO;
import com.company.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentTransformer {

    public DepartmentDTO toDTO(DepartmentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new DepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getLocation()
        );
    }

    public DepartmentEntity toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        return entity;
    }
}

