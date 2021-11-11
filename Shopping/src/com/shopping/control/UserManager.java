package com.shopping.control;

import com.shopping.dao.UserDAO;
import com.shopping.vo.User;

public class UserManager {
	private UserDAO dao = new UserDAO();
	private String login_id;
	private boolean isLogin;
	
	// 회원가입
	public boolean joinUser(User user) {
		boolean result = false;
		// 아이디 중복 확인
		if (dao.check_duplicate_id(user.getUser_id())) {
			result = dao.joinUser(user);
		} 
		
		return result;
	}
	
	// 로그인
	public boolean login(String user_id, String passwd) {
		isLogin = dao.login(user_id, passwd);
		if (isLogin) login_id = user_id;
		
		return isLogin;
	}
	
	// 로그아웃
	public void logout() {
		login_id = null;
		isLogin = false;
	}
	
	public boolean isLogin() {
		return isLogin;
	}
	
	public String getLogin_id() {
		return login_id;
	}
}
