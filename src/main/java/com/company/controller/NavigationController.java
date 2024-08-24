package com.company.controller;

import com.company.dto.DataTableDTO;
import com.company.service.DataTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
public class NavigationController {

private final DataTableService dataTableService;

    @GetMapping("/")
    public String dashboard() {
        log.debug("Inside dashboard");
        return "views/dashboard";
    }

    @ResponseBody
    @PostMapping(value = "/datatable")
    public DataTablesOutput<DataTableDTO> getDataTable(@RequestBody DataTablesInput input) {
        log.debug("inside getDataTable input: {}", input);
        return dataTableService.getAllDataTableEntity(input);
    }
}