package com.ssafy.board.model.service;


import com.ssafy.board.exception.IdIncorrectException;
import com.ssafy.board.model.dto.User;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public interface UserService {
	
	HashMap<String, Object> login(User user) throws NoSuchAlgorithmException, IdIncorrectException, Exception;
	
	void registerUser(User user) throws NoSuchAlgorithmException;
	
	void removeUser(String userId);
	
	void modifyUser(User user);
	
	User getUser(String userId);
	
	
	void loveVideo(String userId, String videoId);
	
	
}
