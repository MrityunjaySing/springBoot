package com.mvc.spring_mvc_crud_jffsrd_m4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring_mvc_crud_jffsrd_m4.dao.EmployeeDao;
import com.mvc.spring_mvc_crud_jffsrd_m4.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public Employee saveMethodDao(Employee employee) {
		return dao.saveMethodDao(employee);
	}
	
	public List<Employee> getAllDataService(){
		
		return dao.getAllDataDao();
	}
	
	public void deleteEmployeeByIdService(int id) {
		dao.deleteEmployeeByIdDao(id);
	}
	
	public Employee getEmployeeByIdService(int id) {
		return dao.getEmployeeByIdDao(id);
	}
		
}
