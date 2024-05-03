package org.cydeo.repository;

import org.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //Display all departments in furniture dptmt.
    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division
    List<Department> findByDivision(String division);

    //Display top 3 departments with division name including 'Hea' without duplicate
    List<Department> findDistinctTop3ByDivisionContains(String division);
}
