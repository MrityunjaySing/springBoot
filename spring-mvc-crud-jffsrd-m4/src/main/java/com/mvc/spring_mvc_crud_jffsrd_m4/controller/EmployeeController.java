package com.mvc.spring_mvc_crud_jffsrd_m4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.spring_mvc_crud_jffsrd_m4.dto.Employee;
import com.mvc.spring_mvc_crud_jffsrd_m4.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping("/")
	public ModelAndView openIndexFile() {
		
		ModelAndView andView = new ModelAndView("index");
		
		andView.addObject("employee", new Employee());
		
		return andView;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		
		service.saveMethodDao(employee);
		ModelAndView andView = new ModelAndView("index");
		
		return andView;
	}
	
	@RequestMapping(value = "/getAllData")
	public ModelAndView getAllEmployeeData() {
		
		ModelAndView andView = new ModelAndView("display");
		
		andView.addObject("list", service.getAllDataService());
		
		return andView;
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView deleteEmployeeById(int id) {
		
		service.deleteEmployeeByIdService(id);
		
		ModelAndView andView = new ModelAndView("display");
		
		andView.addObject("list", service.getAllDataService());
		
		return andView;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView  getEmployeeById(int id) {
		
		Employee employee=service.getEmployeeByIdService(id);
		
		ModelAndView andView = new ModelAndView("update");
		
		andView.addObject("empUpdate", employee);
		
		return andView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView  updateEmployee(@ModelAttribute Employee empUpdate) {
		
		
		
		ModelAndView andView = new ModelAndView("display");
		
		andView.addObject("list", service.getAllDataService());
		
		return andView;
	}
	
	
}
