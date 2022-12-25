package com.ssafy.board.repository;

import java.security.NoSuchAlgorithmException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;
import com.ssafy.board.model.service.UserServiceImpl;

public class UserRegistTest {
	
	UserService userService = new UserServiceImpl();
	
//	@BeforeEach
//	public void beforeEach() {
//		userService = new UserServiceImpl();
//	}
	
	//끝나고 나서는 저장소를 clean시켜줘서 다음 코드를 실행 시킬 때 문제 없이한다.
//	@AfterEach
//	public void afterEach() {
//		if("test".equals(userService.getUser("test"))) {
//			userService.removeUser("test");
//		}
//	}
	//DB와 연동해서 TEST 코드를 짜기 위해서는 조금 더 학습을 진행 후에 하자.
	//그냥 코드 내에서 테스트 할 수 있는 거랑 차이가 조금 있다..
	@Test
	public void 테스트의테스트() {
		try {
			System.out.println("111");
			userService.registerUser(new User("test","test","test","test","test"));
			System.out.println("222");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("333");
			e.printStackTrace();
		}
//		System.out.println(userService.registerUser(new User("test","test","test","test","test"))==null); 
		System.out.println("잘 됌");
	}
//	@Test
//	public void 회원가입(){
//		User user = new User("test","test","test","test","test");
//		try {
////			userService.registerUser(user);
//			System.out.println("succes");
//		} catch (Exception e) {
//			System.out.println(e);
//			Assertions.assertEquals(user,null);
//		}
//		
//	}
	
}
