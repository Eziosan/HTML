package com.shopping.control;

import com.shopping.dao.ShoppingDAO;

public class AdminManager {
	private final String admin_passwd = "abc123";
	private ShoppingDAO shoppingDAO = new ShoppingDAO();
	// 관리자 모드 로그인
	public boolean admin_login(String passwd) {
		if (admin_passwd.equals(passwd)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 주문 취소
	public boolean cancel_order(int order_no) {
		return shoppingDAO.cancel_order(order_no);
	}
}
