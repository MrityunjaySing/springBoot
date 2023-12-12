package com.mvc.spring_mvc_crud_jffsrd_m4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.spring_mvc_crud_jffsrd_m4.dto.Employee;

@Repository
public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Employee saveMethodDao(Employee employee) {

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		return employee;
	}

	public List<Employee> getAllDataDao() {

		return entityManager.createQuery("from Employee").getResultList();
	}

	public void deleteEmployeeByIdDao(int id) {

		Employee employee = entityManager.find(Employee.class, id);

		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
	}

	public Employee getEmployeeByIdDao(int id) {

		Employee employee = entityManager.find(Employee.class, id);

		if (employee != null) {
			
			return employee;
		}else {
			return null;
		}
	}
}
