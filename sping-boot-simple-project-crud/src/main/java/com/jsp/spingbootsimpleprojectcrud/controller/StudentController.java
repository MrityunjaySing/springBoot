package com.jsp.spingbootsimpleprojectcrud.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.spingbootsimpleprojectcrud.dto.Student;
import com.jsp.spingbootsimpleprojectcrud.response.ResponseStructure;
import com.jsp.spingbootsimpleprojectcrud.service.StudentService;

@RestController
@RequestMapping(value = "student")
public class StudentController {

	@Autowired
	private StudentService service;

/*
 * StudentData inserted
 * */
	
	@PostMapping(value ="/create")
	public ResponseStructure<Student> saveStudentController(@RequestBody Student student){
		return service.saveStudentService(student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseStructure<Student> deleteStudentById(@PathVariable int studentId) {
		return service.deleteStudentById(studentId);
	}
	
	/*
	 * Update user name by user id
	 * */
	@PutMapping(value = "/update/{studentId}/{studentName}")
	public Student updateStudentNameById( @PathVariable int  studentId, @PathVariable String studentName) {
		return service.updateStudentNameByIdService(studentId, studentName);
	}
	
	
	@GetMapping(value = "/getStudentById/{studentId}")
	public ResponseStructure<Student> getStudentByIdController(@PathVariable int studentId) {
		return service.getStudentByIdService(studentId);
	}
	/*
	 * find all method
	 */
	@GetMapping(value = "/getAllStudents")
	public ResponseStructure<List<Student>> getAllStudentDataController() {

		return service.getAllStudentDataService();
	}
	
	//save multiple data 
	@PostMapping(value = "/createMany")
	public ResponseStructure<List<Student>> saveMultipleStudentController(@RequestBody List<Student> students){
		
		return service.saveMultipleStudentDao(students);
	}
	//filter
	@GetMapping("/getFilterData")
	public ResponseStructure<List<Student>> getAllStudentOnly4DigitsIdController(){
		return service.getAllStudentOnly4DigitsIdService();
	}
	
	//getByEmail
	@GetMapping("/getStudentByEmail/{studentEmail}")
	public Student findByStudentEmailService(@PathVariable String studentEmail) {
		return service.findByStudentEmailService(studentEmail);
	}
	
	//sort by email in assending order
	@GetMapping(value = "/getSortByEmailASE/{studentEmail}")
	public List<Student> sortByStudentEmailController(@PathVariable String studentEmail){
		return service.sortByStudentEmailService(studentEmail);
	}
	
	//sort by email in desending  order
	@GetMapping(value = "/sortByEmailDes/{studentEmail}")
	public List<Student> sortByStudentEmailDaoDesControler(@PathVariable String studentEmail){
		return service.sortByStudentEmailDaoDesService(studentEmail);
	}
	
	/*
	 * pagination
	 */
	@GetMapping("/pagination/{pageNumber}/{pageSize}")
	public Page<Student> paginationStudentDataController(@PathVariable int pageNumber,@PathVariable int pageSize){
		return service.paginationStudentDataService(pageNumber, pageSize);
	}
	
	/*
	 * paginationWithSorting
	 * 
	 */
	@GetMapping("/pagination/{pageNumber}/{pageSize}/{field}")
	public Page<Student> paginationSortStudentDataController(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String field){
		return service.paginationSortStudentDataService(pageNumber, pageSize, field);
	}
	
	//deleteByStudentId
	@DeleteMapping(value = "/deleteByStudentIdVoid/{studentId}")
	public void deleteByStudentIdService(@PathVariable int  studentId) {
		service.deleteByStudentIdService(studentId);
	}
	
}
