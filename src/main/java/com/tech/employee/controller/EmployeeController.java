package com.tech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.employee.entity.Employee;
import com.tech.employee.exception.AgeException;
import com.tech.employee.exception.CapitalLetterNotBoundException;
import com.tech.employee.exception.NameNotException;
import com.tech.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empscr;
	
	@Autowired
	RestTemplate rt;
	@GetMapping(value="/get")
	public String getString() {
		String url="http://localhost:8080/laptop/hello";
		ResponseEntity<String>s=rt.exchange(url,HttpMethod.GET,null,String.class);
		String x=s.getBody();
		return x.toUpperCase();
	}
	
	
	
	
	

	@PostMapping(value = "/insertEmployee")
	public String addEmployee(@RequestBody Employee e) {
		return empscr.addEmployee(e);
	}
	@PostMapping(value="/listofemployee")
	public String listaddEmployee(@RequestBody List<Employee> emp) {
		return empscr.listaddEmployee(emp);
	}
	
	@GetMapping(value="/finalid/{id}")
	public Employee findid(@PathVariable Integer id) {
		return empscr.findid(id);
	}
	@GetMapping(value="listgetemployee")
	public List<Employee> findallemployee(){
		return empscr.findallemployee();
	}
	@DeleteMapping(value="delete/{ids}")
	public String deleteemp(@PathVariable Integer ids){
		return empscr.deleteemp(ids);
	}
	@PutMapping(value="update/{change}")
	public String updateEmployee(@RequestBody Employee change) {
		return empscr.updateEmployee(change);
	}
	@GetMapping(value="highsalaryname")
	public String getHighSalary() {
		return empscr.getHighSalary();
	}
	@GetMapping(value="highsalary")
	public Employee getEmployee(){
		return empscr.getEmployee();
	}
	
	
	@PostMapping(value="verification")
	public String verified(@RequestBody Employee a) {
		return empscr.verified(a);
		
	}
	
	@GetMapping(value="name/{a}")
	public List<Employee> addletter(@PathVariable String a) {
		return empscr.addletter(a);
	}
	@GetMapping(value="age")
	public List<Employee> findage(@RequestParam int a) {
		return empscr.findage(a);
	}
	
	@GetMapping(value="minsalary")
	public Employee minmployee(){
		return empscr.minemployee();
	}
	
	@GetMapping(value="getbetweensalary")
	public List<Employee>getSalary(@RequestParam int a,@RequestParam int b){
		return empscr.getSalary(a,b);
	}
	
	@GetMapping(value="/agefind")
	public List<Employee>getbyages(@RequestParam int v){
		return empscr.getbyages(v);
	}
	@GetMapping(value="name")
	public List<Employee>getname(@RequestParam String a){
		return empscr.getname(a);
	}
	@GetMapping(value="findgender")
	public List<Employee>getgender(@RequestParam String a){
		return empscr.getgender(a);
	}
	@GetMapping(value="greatersalary")
	public List<Employee>increasesalary(@RequestParam int a){
		return empscr.increasesalary(a);
	}
	@GetMapping(value="senior")
	public String senior() {
		return empscr.senior();
	}
	
	@GetMapping(value="junior")
	public Integer junior() {
		return empscr.junior();
	}
	@PostMapping(value="/inserta")
	public String insertadd(@RequestBody Employee a)throws AgeException,Exception {
		return empscr.insertadd(a);
	}
	
	@GetMapping(value="/names")
	public List<Employee>names(@RequestParam String a)throws NameNotException,Exception{
		return empscr.names(a);
	}
	
	@PostMapping(value="/case")
	public String cases(@RequestBody Employee a)throws CapitalLetterNotBoundException,Exception {
		return empscr.cases(a);
	}
	
//	@GetMapping(value="/ages")
//	public String aged(@RequestBody Employee a) {
//		return empscr.aged(a);
//	}
	
	
	
	
	
}
