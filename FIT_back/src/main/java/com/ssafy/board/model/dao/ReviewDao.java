package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.SearchCondition;

public interface ReviewDao {
	public List<Review> selectAll(String videoId);
	
	public Review selectOne(int reviewId);
	
	public void insertReview(Review review);
	
	public void deleteReview(int reviewId);
	
	public void updateReview(Review review);
	
	public void updateViewCnt(int reviewId);
	
}
