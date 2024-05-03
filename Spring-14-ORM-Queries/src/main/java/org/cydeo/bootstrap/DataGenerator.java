package org.cydeo.bootstrap;

import org.cydeo.entity.Employee;
import org.cydeo.repository.DepartmentRepository;
import org.cydeo.repository.EmployeeRepository;
import org.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------Region Start ------------------");
        System.out.println("   find by country: " + regionRepository.findByCountry("Canada"));
        System.out.println("-----------Region with USA");
        regionRepository.findDistinctByCountry("United States").stream().forEach(r-> System.out.println("USA region: " + r.getRegion()));
        System.out.println("-----------Region where country contains United");
        regionRepository.findByCountryContains("United")
                .stream().forEach(r-> System.out.println("Region with contry containing united: " + r.getRegion()));
        System.out.println("-----------Region where country contains United in order");
        regionRepository.findByCountryContainsOrderByCountry("Asia")
                .stream().forEach(r-> System.out.println("Region with contry containing asia: " + r.getRegion()));
        System.out.println("-----------Top 2 Region where country is United");
        regionRepository.findTop2ByCountry("United States")
                .stream().forEach(r-> System.out.println("Top 2 Regions with contry United States: " + r.getRegion()));

        System.out.println("-----------Region End ------------------\n\n\n");


        System.out.println("-----------Department Start ------------------");

        departmentRepository.findByDepartment("Toys").stream()
                        .forEach(d-> System.out.println("findByDepartment Toys : " + d));

        departmentRepository.findByDivision("Health").stream()
                .forEach(d-> System.out.println("findByDivision Health : " + d));

        departmentRepository.findDistinctTop3ByDivisionContains("Hea").stream()
                .forEach(d-> System.out.println("findDistinctTop3ByDivisionContains Hea : " + d));

        System.out.println("-----------Department End ------------------\n\n\n");

        System.out.println("-----------Employee Start ------------------");

        employeeRepository.findByEmail("acurwood6@1und1.de").stream()
                        .forEach(e-> System.out.println("findByEmail : " + e));

////        employeeRepository.findByFirstNameAndLastNameOrEmail("Berrie","Manueau", "amcnee1@google.es").stream()
////                .forEach(e-> System.out.println("findByFirst_nameAndLast_nameAndEmail : " + e));
//
        employeeRepository.findBySalaryGreaterThan(166000).stream()
                .forEach(e-> System.out.println("findBySalaryGreaterThan 1660000 : " + e));

        employeeRepository.findBySalaryLessThanOrderBySalary(23000).stream()
                .forEach(e-> System.out.println("findBySalaryLessThan 23000 : " + e.getSalary() + " - " + e));

        System.out.println("getEmployeeDetail : " + employeeRepository.getEmployeeDetail());


        System.out.println("-----------Employee End ------------------\n\n\n");


    }
}
