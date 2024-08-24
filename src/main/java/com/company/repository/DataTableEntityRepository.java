package com.company.repository;

import com.company.entity.DataTableEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTableEntityRepository extends DataTablesRepository<DataTableEntity, String> {
}
