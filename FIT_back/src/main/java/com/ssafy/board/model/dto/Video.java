package com.ssafy.board.model.dto;

public class Video {
	private String videoId;
	private String title;
	private String url;
	private String part;
	private String name;
	private int videoViewCnt;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVideoViewCnt() {
		return videoViewCnt;
	}
	public void setVideoViewCnt(int videoViewCnt) {
		this.videoViewCnt = videoViewCnt;
	}
	public Video(String videoId, String title, String url, String part, String name, int videoViewCnt) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.url = url;
		this.part = part;
		this.name = name;
		this.videoViewCnt = videoViewCnt;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", url=" + url + ", part=" + part + ", name=" + name
				+ ", viedoViewCnt=" + videoViewCnt + "]";
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}