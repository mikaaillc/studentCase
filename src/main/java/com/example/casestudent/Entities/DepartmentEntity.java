package com.example.casestudent.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "\"Department\"")
public class DepartmentEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"departmentId\"", nullable = false)
    private Long id;

    @Column(name = "\"name\"")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}