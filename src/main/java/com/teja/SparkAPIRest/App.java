package com.teja.SparkAPIRest;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.after;

import com.google.gson.Gson;
import com.teja.DAO.CourseDAO;
import com.teja.DAO.SQL2OCourseDAO;
import com.teja.model.Course;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Gson gson = new Gson();
        CourseDAO courseDAO = new SQL2OCourseDAO();
        
        get("/hello",(req,res)-> {
            System.out.println( "Hello World!" );
        	return "Welcome to spark web application";
        });
        
        post("/courses","application/json",(req,res)-> {
        	System.out.println("In the post of courses");
        	Course course = gson.fromJson(req.body(),Course.class);
        	courseDAO.add(course);
        	res.status(201);
        	res.type("application/json");
        	return  course;
        },gson::toJson);
        
        get("/courses","application/json",
        		(req,res)-> courseDAO.findAll(),gson::toJson);
        
    
        after(
        		(req,res) -> 
        		{
        			res.type("application/json");   			
        			}
        		);
    
    
}
}
