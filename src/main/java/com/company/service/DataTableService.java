package com.company.service;

import com.company.dto.DataTableDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

public interface DataTableService {

    DataTablesOutput<DataTableDTO> getAllDataTableEntity(DataTablesInput input);

}