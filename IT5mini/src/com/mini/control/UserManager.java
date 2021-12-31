package com.mini.control;

import com.mini.dao.UserDAO;
import com.mini.vo.SongComment;
import com.mini.vo.UserInfo;

public class UserManager {
	//현재 로그인 한 사람의 ID
	private String loginId;
	//로그인 됐는지 여부
	private boolean isLogin = false;
	UserDAO ud = new  UserDAO(); 
	
	public UserManager() {}
	
	//회원가입. 성공시 true리턴
	public boolean signUp(UserInfo ui) {
		return ud.signUp(ui);
	}
	
	//로그인. 성공시 loginId, isLogin에 값을 넣음
	public boolean login(String id, String password) {
		if(ud.login(id, password)) {
			loginId = id;
			isLogin = true;
			return true;
		}
		
		return false;
	}
	
	//로그인 여부 확인. true면 로그인 되어있음
	public boolean isLogin() {
		return isLogin;
	}
	
	//로그아웃
	public void logout() {
		isLogin = false;
	}
	
	//현재 로그인 id 가져옴
	public String getLoginId() {
		return loginId;
	}
	
	/*
	 * 1. 로그인 / 로그아웃 UI
	 * 2. 로그인이 필요한 곳에 달아야
	 */
	
}
