package com.ssafy.board.model.dao;

import java.util.HashMap;

import com.ssafy.board.model.dto.User;

public interface UserDao {

	public void insertUser(User user);

	public void deleteUser(String id);
	
	public User selectUser(String id);
	
	public void updateUser(User user);
	
	public void likeVideo(HashMap<String, String> map);


	
	
	

}
