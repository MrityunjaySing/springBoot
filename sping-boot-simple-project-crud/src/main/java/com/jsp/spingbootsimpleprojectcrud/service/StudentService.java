
package com.jsp.spingbootsimpleprojectcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.spingbootsimpleprojectcrud.dao.StudentDao;
import com.jsp.spingbootsimpleprojectcrud.dto.Student;
import com.jsp.spingbootsimpleprojectcrud.response.ResponseStructure;

@Service
public class StudentService {
    
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ResponseStructure<Student> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Student>> responseStructure2;
	
	
	//Save method of the service Class
	public ResponseStructure<Student> saveStudentService(Student student){
	   Student student2= studentDao.saveStudentDao(student);
	   
	   if(student2 != null) {
		   responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		   responseStructure.setStatusMessage("data Stored");
		   responseStructure.setStatusDiscription("data is stored please don't stored again");
		   responseStructure.setStatusData(student2);
	   }
	   else {
		   responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		   responseStructure.setStatusMessage("data--Stored");
		   responseStructure.setStatusDiscription("data is stored please don't stored again");
		   responseStructure.setStatusData(student2);//null we can put
	   }
	   
	   return responseStructure;
	}
	
	
	//delete
	public ResponseStructure<Student> deleteStudentById(int studentId) {
		if(studentDao.deleteStudentById(studentId)) {
			   responseStructure.setStatusCode(HttpStatus.FOUND.value());
			   responseStructure.setStatusMessage("data has been deleted");
			   responseStructure.setStatusDiscription("=============");
			   responseStructure.setStatusData(null);
		   }
		else {
			   responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			   responseStructure.setStatusMessage("data--Found");
			   responseStructure.setStatusDiscription("please chech your studentId");
			   responseStructure.setStatusData(null);
		}
		return responseStructure;
		}
	
	/*
	 * Update user name by user id
	 * */
	public Student updateStudentNameByIdService(int studentId, String studentName) {
		return studentDao.updateStudentNameByIdDao(studentId, studentName);
	}
	/**
	 * get by id method
	 */
	public ResponseStructure<Student> getStudentByIdService(int studentId) {

		Student student2 = studentDao.getStudentByIdDao(studentId);

		if (student2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setStatusMessage("data---found");
			responseStructure.setStatusDiscription("it is data which is present ");
			responseStructure.setStatusData(student2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setStatusMessage("data-is-not--found");
			responseStructure.setStatusDiscription("please check your id");
			responseStructure.setStatusData(student2);
		}

		return responseStructure;
	}
	

	/*
	 * find all method
	 */
	public ResponseStructure<List<Student>> getAllStudentDataService() {

		List<Student> list=studentDao.getAllStudentDataDao();
		
		if(list!=null) {
			responseStructure2.setStatusCode(HttpStatus.FOUND.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDiscription("please check your id");
			responseStructure2.setStatusData(list);
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDiscription("please check your id");
			responseStructure2.setStatusData(list);
		}
		
		return responseStructure2;
	}
	
	//save multiple data
	public ResponseStructure<List<Student>> saveMultipleStudentDao(List<Student> students){
		     List<Student> students2= studentDao.saveMultipleStudentDao(students);
		     
				if(students2 !=null) {
					responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure2.setStatusMessage("data-is-not--found");
					responseStructure2.setStatusDiscription("please check your id");
					responseStructure2.setStatusData(students2);
				}else {
					responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
					responseStructure2.setStatusMessage("data-is-not--found");
					responseStructure2.setStatusDiscription("please check your id");
					responseStructure2.setStatusData(students2);
				}
				
				return responseStructure2;
			}
	
	//filter
	public ResponseStructure<List<Student>> getAllStudentOnly4DigitsIdService(){
		
		List<Student> list=studentDao.getAllStudentOnly4DigitsIdDao();
		
		System.out.println(list);
		List<Student> filters = new ArrayList<Student>();
		
		if(!(list.isEmpty())) {
			
			for (Student student : list) {
				int id = student.getId();
				if(id>999&&id<10000) {
					filters.add(student);
					responseStructure2.setStatusCode(HttpStatus.FOUND.value());
					responseStructure2.setStatusMessage("data-is-not--found");
					responseStructure2.setStatusDiscription("please check your id");
					responseStructure2.setStatusData(filters);
				}else {
					responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
					responseStructure2.setStatusMessage("no id with 4 digits available ");
					responseStructure2.setStatusDiscription("please check your id");
					responseStructure2.setStatusData(filters);
				}
			}
			
			
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusMessage("there is not data in table");
			responseStructure2.setStatusDiscription("please check your id");
			responseStructure2.setStatusData(list);
		}
		
		return responseStructure2;
	}
	
	//getByEmail
	public Student findByStudentEmailService(String studentEmail) {
		return studentDao.findByStudentEmailDao(studentEmail);
	}
	
	//sortByEmailInAsendingOrder
	public List<Student> sortByStudentEmailService(String studentEmail){
		return studentDao.sortByStudentEmailDao(studentEmail);
	}
	
	//sort by email in desending  order
	public List<Student> sortByStudentEmailDaoDesService(String studentEmail){
		return studentDao.sortByStudentEmailDaoDes(studentEmail);
	}
	
	/*
	 * pagination
	 */
	public Page<Student> paginationStudentDataService(int pageNumber,int pageSize){
		return studentDao.paginationStudentDataDao(pageNumber, pageSize);
	}
	
	/*
	 * paginationWithSorting
	 * 
	 */
	public Page<Student> paginationSortStudentDataService(int pageNumber,int pageSize,String field){
		return studentDao.paginationSortStudentDataDao(pageNumber, pageSize, field);
	}
	//deleteByStudentId
	public void deleteByStudentIdService(int studentId) {
		studentDao.deleteByStudentId(studentId);
	}
 }
