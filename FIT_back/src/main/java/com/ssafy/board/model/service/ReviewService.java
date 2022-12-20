package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Review;

public interface ReviewService {
	
	List<Review> getReviewList(String videoId);

	Review readReview(int id);

	void writeReview(Review review);

	void modifyReview(Review review);

	void removeReview(int id);

	Review getReview(int id);

}
