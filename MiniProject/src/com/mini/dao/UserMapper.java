package com.mini.dao;

import java.util.HashMap;

import com.mini.vo.UserInfo;

public interface UserMapper {
	//회원가입
	public int signUp(UserInfo ui);
	
	//중복 체크. 
	public int dupulicate_check(String id);
	
	//로그인
	public int login(HashMap<String, String> ui);
}
