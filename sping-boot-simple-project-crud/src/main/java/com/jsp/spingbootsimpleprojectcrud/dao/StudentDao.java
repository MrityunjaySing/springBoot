package com.jsp.spingbootsimpleprojectcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.jsp.spingbootsimpleprojectcrud.dto.Student;
import com.jsp.spingbootsimpleprojectcrud.repository.StudentRepository;

@Repository
public class StudentDao {
	
	
   public int addThreeNumber(int a,int b,int c) {
	   return a+b+c;
   }
	
   @Autowired
   private StudentRepository repository;
   
	public Student saveStudentDao(Student student) {
		
		return repository.save(student);
	}
     
	//delete
	public boolean deleteStudentById(int studentId) {
		Optional<Student> optional= repository.findById(studentId);
		
		if(optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Update user name by user id
	 * */
	public Student updateStudentNameByIdDao(int studentId, String studentName) {
		Student student = getStudentByIdDao(studentId);
		if(student!=null) {
			student.setStudentName(studentName);
			repository.save(student);
			return student;
		}else {
			return null;
		}
	}
	
	/**
	 * get by id method
	 */
	public Student getStudentByIdDao(int studentId) {
		Optional<Student> optional = repository.findById(studentId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	/*
	 * find all method
	 */
	public List<Student> getAllStudentDataDao(){
		
		return repository.findAll();
	}
	
	//save multiple data
	public List<Student> saveMultipleStudentDao(List<Student> students){
		return repository.saveAll(students);
	}
	
	//filter
	public List<Student> getAllStudentOnly4DigitsIdDao(){
		
		return getAllStudentDataDao();
	}
	
	//find by Email
	public Student findByStudentEmailDao(String studentEmail) {
		return repository.findBystudentEmail(studentEmail);
	}
	
	//sort by email in assending order
	public List<Student> sortByStudentEmailDao(String studentEmail){
		return repository.findAll(Sort.by(Sort.Direction.ASC,studentEmail));
	}
	
	//sort by email in desending  order
	public List<Student> sortByStudentEmailDaoDes(String studentEmail){
		return repository.findAll(Sort.by(Sort.Direction.DESC,studentEmail));
	}
	//deleteByStudentId
	public void deleteByStudentId(int studentId) {
		repository.deleteCopyByTradeId(studentId);
	}
	
	/*
	 * pagination
	 */
	public Page<Student> paginationStudentDataDao(int pageNumber,int pageSize){
	
		return repository.findAll(PageRequest.of(pageNumber, pageSize));
	}
	/*
	 * paginationWithSorting
	 * 
	 */
	public Page<Student> paginationSortStudentDataDao(int pageNumber,int pageSize,String field){
		
		return repository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Direction.ASC,field));
	}

	
}
