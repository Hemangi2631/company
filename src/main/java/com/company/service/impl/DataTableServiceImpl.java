package com.company.service.impl;

import com.company.dto.DataTableDTO;
import com.company.repository.DataTableEntityRepository;
import com.company.service.DataTableService;
import com.company.transformer.DataTableTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DataTableServiceImpl implements DataTableService {

    private final DataTableEntityRepository repository;
    private final DataTableTransformer transformer;

    @Override
    public DataTablesOutput<DataTableDTO> getAllDataTableEntity(DataTablesInput input) {
        return repository.findAll(input, transformer::toDTO);
    }

}