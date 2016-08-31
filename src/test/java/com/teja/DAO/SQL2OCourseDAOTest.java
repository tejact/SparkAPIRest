package com.teja.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.teja.model.Course;

public class SQL2OCourseDAOTest {
	
	CourseDAO dao; 

	@Before
	public void setUp() throws Exception {
		dao = new SQL2OCourseDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addCourseSetsID() {
		Course course = new Course("Test","www");
		int originalCourseID = course.getId();
		
		dao.add(course);
		
		assertNotEquals(originalCourseID,course.getId());
		
	}

}
