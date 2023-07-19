package com.tech.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.employee.dao.EmployeeDao;
import com.tech.employee.entity.Employee;
import com.tech.employee.exception.AgeException;
import com.tech.employee.exception.CapitalLetterNotBoundException;
import com.tech.employee.exception.NameNotException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String listaddEmployee(List<Employee> emp) {
		return empDao.listaddEmployee(emp);
	}

	public Employee findid(Integer id) {
		return empDao.findid(id);
	}

	public List<Employee> findallemployee() {
		return empDao.findallemployee();
	}

	public String deleteemp(Integer ids) {
		return empDao.deleteemp(ids);
	}

	public String updateEmployee(Employee change) {
		return empDao.updateEmployee(change);
	}

	public String getHighSalary() {
		List<Employee> allemp = empDao.findallemployee();
		Employee max = allemp.stream().max(Comparator.comparing(Employee::getSalary)).get();
		return max.getName();
	}

	public Employee getEmployee() {
		List<Employee> emp = empDao.findallemployee();
		Employee max = emp.stream().max(Comparator.comparing(Employee::getSalary)).get();
		return max;
	}

	public String verified(Employee a) {
		if (a.getAge() >= 18) {
			return empDao.addEmployee(a);
		} else {
			return "must 18";
		}
	}
	public List<Employee> addletter(String a) {
		List<Employee> emp=empDao.findallemployee();
	List<Employee> name =emp.stream().filter(x->x.getName().equalsIgnoreCase(a)).collect(Collectors.toList());
	  return name;
	}
	public List<Employee> findage(int a) {
		List<Employee> emp=empDao.findallemployee();
		List<Employee>age=emp.stream().filter(x->x.getAge()==a).collect(Collectors.toList());
		return age;
	}
	
	public Employee minemployee(){
		List<Employee> emp = empDao.findallemployee();
		Employee min = emp.stream().min(Comparator.comparing(Employee::getSalary)).get();
		return min;
	}
	
	public List<Employee>getSalary(int a, int b){
		List<Employee>emp=empDao.findallemployee();
		List<Employee> betweensalary=emp.stream().filter(x->x.getSalary()>a&&x.getSalary()<b).collect(Collectors.toList());
		 return betweensalary;
		
	}
	
	public List<Employee>getbyages(int v){
		return empDao.getbyages(v);
	}
	public List<Employee>getname(String a){
		//return empDao.findallemployee().stream().filter(x->x.getName().equalsIgnoreCase(a)).collect(Collectors.toList());
		return empDao.getname(a);
	}
	public List<Employee>getgender(String a){
		
		return empDao.getgender(a);
	}
	public List<Employee>increasesalary(int a){
		return empDao.increasesalary(a);
	}
	public String senior() {
		return empDao.senior();
	}
	public Integer junior() {
		return empDao.junior();
	}
	public String insertadd(Employee a)throws AgeException,Exception {
		try {
		if(a.getAge()<=18) {
			throw new AgeException("please Enter valid age");
		}else {
			return empDao.addEmployee(a);
		}
	}catch(Exception e) {
		return e.getMessage();
		
	}
	}
	
public List<Employee>names(String a)throws NameNotException,Exception{
	
		List<Employee>emp=empDao.findallemployee().stream().filter(x->x.getName().equals(a)).collect(Collectors.toList());
		//return empscr.names(a);
		if(emp.isEmpty()) {
			throw new NameNotException("it is empty");
		}else {
			return emp;
		}
	}
//public List<Employee> findage(int a) {
//	List<Employee> emp=empDao.findallemployee();
//	List<Employee>age=emp.stream().filter(x->x.getAge()==a).collect(Collectors.toList());
//	return age;
//}
public String cases(Employee a) throws CapitalLetterNotBoundException,Exception{
	if(a.getName().charAt(0)>='A'&&a.getName().charAt(0)<='Z') {
	return empDao.cases(a);
	}else {
		throw new CapitalLetterNotBoundException("not case sensitivity");
	}
}

//public String aged(Employee a) {
//	if(a.getAge()>=18) {
//		
//		
//	}
//}


}
