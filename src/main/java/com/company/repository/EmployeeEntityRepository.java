package com.company.repository;

import com.company.entity.EmployeeEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String>, DataTablesRepository<EmployeeEntity, String> {

    List<EmployeeEntity> findByDepartmentId(String departmentId);

    @Transactional
    void deleteByDepartmentIdAndId(String departmentId, String employedId);
}