package com.teja.DAO;

import java.util.List;

import com.teja.model.Course;

public interface CourseDAO {
	void add(Course course);
	List<Course> findAll();
}
