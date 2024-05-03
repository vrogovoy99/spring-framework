package org.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @ManyToOne()
    @JoinColumn(name = "department")
    private Department department;
    @Enumerated (value = EnumType.STRING)
    private Gender gender;
    private Integer salary;
    @ManyToOne
    private Region region;
}
