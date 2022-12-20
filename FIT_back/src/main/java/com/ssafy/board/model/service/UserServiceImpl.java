package com.ssafy.board.model.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.controller.SHA256;
import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

import com.ssafy.board.exception.IdIncorrectException;
import com.ssafy.board.exception.PwIncorrectException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
	}

	// 로그인
	@Transactional
	@Override
	public HashMap<String, Object> login(User u) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		User user = userDao.selectUser(u.getId());
//		System.out.println(u.getId());
//		System.out.println(u.getPassword());
//		System.out.println(user.getName());
		// 유저 아이디가 없으면 아이디 불일치 예외처리
		if (user == null) {
			System.out.println("user is null");
			throw new IdIncorrectException();
		}
		// 비밀번호가 다른 경우 비밀번호 불일치 예외처리
		else if (!user.getPassword().equals(new SHA256().getHash(u.getPassword()))) {
			System.out.println("user password not correct");
			throw new PwIncorrectException();
		}
		// 다 성공이면 결과에 유저 정보 저장
		else {
//			System.out.println("UseService success!");
			result.put("user", user);
			return result;
		}
//		return result;
	}


	@Override
	public User getUser(String userId) {
		return userDao.selectUser(userId);
	}

	@Override
	public void registerUser(User user) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		user.setPassword((new SHA256().getHash(user.getPassword())));
		userDao.insertUser(user);

	}

	@Override
	public void removeUser(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);

	}

	@Override
	public void loveVideo(String userId, String videoId) {

	}

}
