package com.company.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class DataTableDTO {
    private String id;
    private String name;
    private String email;
    private String position;
    private Integer salary;
    private String departmentId;
    private String location;
    private String departmentName;
}