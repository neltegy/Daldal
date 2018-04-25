package com.daldal.springboot.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daldal.springboot.mapper.UserMapper;
import com.daldal.springboot.userdto.UserJoinDto;
import com.daldal.springboot.userdto.UserLoginDto;
import com.daldal.springboot.uservo.UserLoginVo;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper usermapper;
	
	public UserLoginVo selectNickNameByUserIdAndPw(Map<String, String> map) {
		UserLoginVo userloginvo = usermapper.selectNickNameByUserIdAndPw(map);
		return userloginvo;
	}

	public void insertUserJoinDto(UserJoinDto userjoindto) {
		// TODO Auto-generated method stub
		usermapper.insertUserJoinDto(userjoindto);
	}
}
