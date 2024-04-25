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
    private String firstName;
    @Column(columnDefinition = "varchar(50)")
    private String lastName;
    @Column(columnDefinition = "varchar(50)")
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(1)")
    private Gender gender;
    private  int salary;
//    public int region_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId") //change the name of the join column
    private Department department;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
