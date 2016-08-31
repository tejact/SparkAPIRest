package com.teja.DAO;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.teja.model.Course;

public class SQL2OCourseDAO implements CourseDAO {

	
	//Memory based H2
	/*String connectionString = "jdbc:h2:mem:testing;"
			+ "INIT=RUNSCRIPT from 'classpath:data/init.sql'";*/
	
	//File based H2
	String connectionString = "jdbc:h2:~/review.db;"
			+ "INIT=RUNSCRIPT from 'classpath:data/init.sql' ";
	Sql2o sql2o = new Sql2o(connectionString,"","");

	

	public void add(Course course) {
		// TODO Auto-generated method stub
		String sql =  	"INSERT INTO courses(name, URL) " +
						"VALUES (:name, :URL)";

		//Try with resources
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql)
			.bind(course)
			.executeUpdate()
			.getKey();
			
			course.setId(id);
		}		
	}

	public List<Course> findAll() {
		List<Course> courses;
		String sql =
				"SELECT id, name, url " +
						"FROM courses ";

		try(Connection con = sql2o.open()) {
			courses = 
					con.createQuery(sql)
					.executeAndFetch(Course.class);
		}

		return courses;
	}

}
