package com.teja.DAO;

import java.util.List;

import com.teja.model.Review;

public interface ReviewDAO {
	
	void add(Review review);
	List<Review> findAll();
	List<Review> findByCourseId(int courseID);

}
