package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "department")
public class DepartmentEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
}