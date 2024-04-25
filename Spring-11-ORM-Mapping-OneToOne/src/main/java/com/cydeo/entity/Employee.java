package com.cydeo.entity;
import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity{

    @Column(columnDefinition = "varchar(50)")
    public String firstName;
    @Column(columnDefinition = "varchar(50)")
    public String lastName;
    @Column(columnDefinition = "varchar(50)")
    public String email;
    @Column(columnDefinition = "DATE")
    public LocalDate hireDate;
//    @Column(columnDefinition = "varchar(17)")
//    public String department;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(1)")
    public Gender gender;
    public  int salary;
//    public int region_id;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
