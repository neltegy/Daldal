package com.daldal.springboot.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daldal.springboot.dao.UserDao;
import com.daldal.springboot.userdto.UserJoinDto;
import com.daldal.springboot.userdto.UserLoginDto;
import com.daldal.springboot.uservo.UserLoginVo;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	
	public UserLoginVo loginsession(Map<String, String> map) {
		UserLoginVo userloginvo = userdao.selectNickNameByUserIdAndPw(map);
		return userloginvo;
	}

	public void join(UserJoinDto userjoindto) {
		// TODO Auto-generated method stub
		userdao.insertUserJoinDto(userjoindto);
	}
}
