package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.exception.IdIncorrectException;
import com.ssafy.board.exception.PwIncorrectException;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	private static final String HEADER_AUTH = "access-token";
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserService userService;

	// 회원가입
	@PostMapping("/user/join")
	public ResponseEntity<String> join(User user) throws Exception {
		userService.registerUser(user);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	// 로그인
	@PostMapping("/user/login")
	public ResponseEntity<Map<String, Object>> login(User user) throws Exception {
		Map<String,Object> result = new HashMap<>();
		HttpStatus status = null;
		
		try {
			result=userService.login(user);
			String accessToken = jwtUtil.createToken(user.getId());
			result.put("access-token",accessToken);
			result.put("message",SUCCESS);
			User userInf = jwtUtil.getInfo(accessToken);
			result.put("user",userInf);
		} catch (UnsupportedEncodingException e){
			System.out.println(1111111111);
			result.put("message",FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}catch (IdIncorrectException e) {
			System.out.println(2222222);
			result.put("msg", "해당 아이디의 유저가 없습니다!");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
		} catch (PwIncorrectException e){
			System.out.println(33333333);
			result.put("msg", "비밀번호가 일치하지 않습니다.");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
		}
		status = HttpStatus.OK;
		System.out.println("success");
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	
	//  회원 정보 수정
	@PutMapping("/user/modify")
	public ResponseEntity<User> modifyUser(User user) {
		userService.modifyUser(user); 
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//  회원 탈퇴
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
//		String id= user.getId();
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		userService.removeUser(id);  
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	



}
