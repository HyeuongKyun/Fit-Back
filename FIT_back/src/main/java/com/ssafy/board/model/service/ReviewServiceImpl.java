package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.ReviewDao;
import com.ssafy.board.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDao reviewDao;
	
	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<Review> getReviewList(String videoId) {
		return reviewDao.selectAll(videoId);
	}

	@Transactional
	@Override
	public Review readReview(int reviewId) {
		reviewDao.updateViewCnt(reviewId);
		return reviewDao.selectOne(reviewId);
	}

	@Transactional
	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
	}

	@Transactional
	@Override
	public void modifyReview(Review review) {
		reviewDao.updateReview(review);
	}

	@Transactional
	@Override
	public void removeReview(int reviewId) {
		reviewDao.deleteReview(reviewId);
	}

	@Override
	public Review getReview(int reviewId) {
		return reviewDao.selectOne(reviewId);
	}

	

}
