package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserMapper;

/**
 * 
 * @author satakemisako
 * 
 * ユーザーログイン時のサービスクラス
 *
 */
@Service
public class UserLoginService {

	@Autowired
	private UserMapper mapper;
	
	public User findByUserIdAndPassword(String userId,String password){
		User user = new User();
		user = mapper.findByUserIdAndPassword(userId, password);
		return user;
	}
	
	public void insertUser(User user) {
		mapper.insertUser(user);
	}
	
}
