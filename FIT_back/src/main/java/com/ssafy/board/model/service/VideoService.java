package com.ssafy.board.model.service;

import java.util.List;
import com.ssafy.board.model.dto.Video;

public interface VideoService {
	List<Video> getAllVideoList();
	List<Video> getVideoList(String part);
	Video getVideo(String id);
}
