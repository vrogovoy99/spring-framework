package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity{
//    @Id
    @Column(columnDefinition = "varchar(100)")
    public String department;
    @Column(columnDefinition = "varchar(100)")
    public String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
