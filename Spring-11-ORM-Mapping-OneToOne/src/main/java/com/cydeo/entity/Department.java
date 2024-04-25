package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity{
//    @Id
    @Column(columnDefinition = "varchar(100)")
    private String department;
    @Column(columnDefinition = "varchar(100)")
    private String division;
    @OneToOne(mappedBy = "department") //mappedBy name has to be the same name as other object is mapped to this class.
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
