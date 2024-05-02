package org.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cydeo.enums.Gender;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity {
    private String first_name;
    private String last_name;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hire_date;
    @ManyToOne ()
    @JoinColumn(name = "department")
    private Department department;
    @Enumerated (value = EnumType.STRING)
    private Gender gender;
    private Long salary;
    @ManyToOne
    private Region region;
}
