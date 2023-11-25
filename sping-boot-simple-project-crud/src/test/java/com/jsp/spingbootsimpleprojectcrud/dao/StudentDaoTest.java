package com.jsp.spingbootsimpleprojectcrud.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentDaoTest {

	private final StudentDao dao  = new StudentDao();
	@Test
	void addThreeNumber() {
		assertEquals(30,dao.addThreeNumber(10, 10, 10));
	}

}
