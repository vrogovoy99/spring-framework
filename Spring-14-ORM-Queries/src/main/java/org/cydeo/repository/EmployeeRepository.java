package org.cydeo.repository;

import org.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Display all employees with email address Bla

    List<Employee> findByEmail(String email);
//
//    //Display employees with a given first name, last name and also email.
//    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);
//
//    //Display all employees that first name is not bla
//    List<Employee> findByFirstNameIsNot(String firstName);
//
    //Display all employees where last mame starts with bla
//    List<Employee> findByLastNameStartingWith(String lastName);

    //Display all employee with salary greater than
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employee with salary Less than
    List<Employee> findBySalaryLessThanOrderBySalary(Integer salary);

    //Display employees that were hired in a given period
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employee with salary greater than in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top 3 employees with salary less than bla
    List<Employee> findDistinctTop3BySalaryLessThanOrderBySalary(Integer salary);

    // Display employees without email
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email='amcnee1@google.es'")
    Employee getEmployeeDetail();
    @Query("SELECT e.salary FROM Employee e WHERE e.firstName='Aeriell'")
    Integer getEmployeeSalary();
    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);
    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, Integer salary);
    @Query("SELECT count(e) FROM Employee e")
    Integer getEmployeeCount();

    // not equal
    @Query("SELECT e FROM Employee e WHERE e.salary>50000 and e.salary!=?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    // like/contains/startswith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName like ?1 ")
    List<Employee> getEmployeeFirstNameLike(String pattern);
    // SQL query
    @Query(value = "SELECT * FROM employees  WHERE salary BETWEEN ?1 AND ?2 ORDER BY salary", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salaryStart, int salaryEnd);
    @Query(value = "SELECT * FROM employees  WHERE salary BETWEEN :salaryStart AND :salaryEnd ORDER BY salary", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalaryParam(@Param("salaryStart") int salaryStart, @Param("salaryEnd") int salaryEnd);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email='bla' WHERE e.id = :id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='bla-bla-bla' WHERE id = :id", nativeQuery = true)
    void updateEmployeeSQL(@Param("id") int id);



}
