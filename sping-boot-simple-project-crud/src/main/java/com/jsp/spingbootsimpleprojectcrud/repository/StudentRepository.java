package com.jsp.spingbootsimpleprojectcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jsp.spingbootsimpleprojectcrud.dto.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findBystudentEmail(String studentEmail);
	

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student where id = ?1 ; ", nativeQuery = true)
    void deleteCopyByTradeId(Integer id);
    
   
}
