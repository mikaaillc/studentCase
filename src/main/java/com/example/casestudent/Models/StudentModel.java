package com.example.casestudent.Models;

import com.example.casestudent.Entities.DepartmentEntity;
import lombok.Data;

import java.sql.Date;
@Data
public class StudentModel {

    private Long id;
    private DepartmentEntity departmentEntity;
    private String name;
    private Date birthday;

}