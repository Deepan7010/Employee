package com.tech.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

@Query(value="Select*from employee_details where age>=?",nativeQuery=true)
public List<Employee> getbyages(int v);

@Query(value="select*from employee_details where name like?",nativeQuery=true)
public List<Employee>getname(String a);

@Query(value="select*from employee_details where gender like?",nativeQuery=true)
public List<Employee>getgender(String a);

@Query(value="select*from employee_details where salary>=?",nativeQuery=true)
public List<Employee>increasesalary(int a);

@Query(value="select name from employee_details where id=(select min(id)from employee_details)",nativeQuery=true)
public String senior();

@Query(value="select id from employee_details where id=(select max(id)from employee_details)",nativeQuery=true)
public Integer junior();

}
