package com.mvc.spring_mvc_crud_jffsrd_m4.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	private int id;
	private String name;
	private String email;
}
