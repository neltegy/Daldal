package com.daldal.springboot.mapper;

import java.util.Map;

import com.daldal.springboot.userdto.UserJoinDto;
import com.daldal.springboot.uservo.UserLoginVo;

public interface UserMapper {
	public String selectId(String joinIdCheck);
	public UserLoginVo selectNickNameByUserIdAndPw(Map<String, String> map);
	public void insertUserJoinDto(UserJoinDto userjoindto);
}
