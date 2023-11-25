package com.jsp.spingbootsimpleprojectcrud.dto;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@Column(name ="id",length = 10)
	private int id;
	@Column(name="name",length = 20,nullable = false)
	private String studentName;	
	@Column(name="email",nullable = false,unique = true)
	private String studentEmail;
	@Column(name="phone", length = 13,unique = true)
	private long studentPhone;

	
	
}
