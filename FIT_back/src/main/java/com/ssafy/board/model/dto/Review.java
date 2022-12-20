package com.ssafy.board.model.dto;

public class Review {

	private String videoId;
	private String userId;
	private int reviewId;
	private String title;
	private String content;
	private int reviewViewCnt;
	private String createAt;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String videoId, String userId, String title, String content) {
		super();
		this.videoId = videoId;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReviewViewCnt() {
		return reviewViewCnt;
	}

	public void setReviewViewCnt(int reviewViewCnt) {
		this.reviewViewCnt = reviewViewCnt;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Review [videoId=" + videoId + ", userId=" + userId + ", reviewId=" + reviewId + ", title=" + title
				+ ", content=" + content + ", reviewViewCnt=" + reviewViewCnt + ", createAt=" + createAt + "]";
	}

}