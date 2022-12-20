package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.exception.BoardNotFoundException;
import com.ssafy.board.exception.VideoNotFoundException;
import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.service.ReviewService;
import com.ssafy.board.model.service.VideoService;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	@Autowired
	private VideoService videoService;

	@Autowired
	private ReviewService reviewService;

	// 모든 동영상을 보여줄게요
	@GetMapping("/board")
	public ResponseEntity<List<Video>> list() {
		return new ResponseEntity<List<Video>>(videoService.getAllVideoList(), HttpStatus.OK);
	}
	
	// 부위별 영상을 보여줄게요
	@GetMapping("/board/part/{part}")
	public ResponseEntity<List<Video>> partVideos(@PathVariable String part){
		try {
			return new ResponseEntity<List<Video>>(videoService.getVideoList(part), HttpStatus.OK);
		}catch (Exception e) {
			throw new VideoNotFoundException(part + "부위 영상은 없어용.");
		}
	}
	
	// 하나의 동영상을 보여줄게요(예외처리가 되어있지 않으므로 반드시 있는 존재하는 videoId만 넘겨야 한다.)
	@GetMapping("/board/{videoId}")
	public ResponseEntity<Video> getOneVideo(@PathVariable String videoId) {
		Video currV = videoService.getVideo(videoId);
		return new ResponseEntity<Video>(currV, HttpStatus.OK);
//		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	// 해당 동영상에 달려있는 리뷰들을 모두 보여줄게요
	@GetMapping("/board/reviews/all/{videoId}")
	public ResponseEntity<List<Review>> getAllReview(@PathVariable String videoId) {
		List<Review> reviewList = reviewService.getReviewList(videoId);
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
	}

	// 하나의 리뷰만 보여줄게요
	@GetMapping("/board/reviews/one/{reviewId}")
	public ResponseEntity<Review> getOneReview(@PathVariable int reviewId) {
		Review review = reviewService.readReview(reviewId);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 해당 동영상에 리뷰를 작성할게요
	@PostMapping("/board/video/{videoId}")
	public ResponseEntity<String> write(Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	// 해당 리뷰를 수정할게요
	@PutMapping("/board/review")
	public ResponseEntity<Review> modifyReview(Review review) {
		reviewService.modifyReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 해당 리뷰를 삭제할게요
	@DeleteMapping("/board/review/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
		reviewService.removeReview(reviewId);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

}
