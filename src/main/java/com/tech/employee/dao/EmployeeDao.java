package com.tech.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.employee.entity.Employee;
import com.tech.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "successfully saved";
	}

	public String listaddEmployee(List<Employee> emp) {
		empRepo.saveAll(emp);
		return "Successfully";
	}

	public Employee findid(Integer id) {
		return empRepo.findById(id).get();
		// return "successfully id";
	}
	public List<Employee> findallemployee(){
		return empRepo.findAll();
	}
	public String deleteemp(Integer ids){
		 empRepo.deleteById(ids);
		return "ss";
	}
	public String updateEmployee(Employee change) {
		empRepo.save(change);
		return "successfully update";
	}
//	public Employee verified(String a) {
//		return empRepo.findById(a).get();
//		//return // "successfully";
//	}
	
	public List<Employee>getbyages(int v){
		return empRepo.getbyages(v);
	}
	
	public List<Employee>getname(String a){
		return empRepo.getname(a);
	}
	public List<Employee>getgender(String a){
		return empRepo.getgender(a);
	}
	public List<Employee>increasesalary(int a){
		return empRepo.increasesalary(a);
	}
	public String senior() {
		return empRepo.senior();
	}
	public Integer junior() {
		return empRepo.junior();
	}
	public String cases(Employee a) {
		empRepo.save(a);
		return "sucessfully";
	}
	
	
}
