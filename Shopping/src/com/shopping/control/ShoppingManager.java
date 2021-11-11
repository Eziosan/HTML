package com.shopping.control;

import java.util.*;

import com.shopping.dao.ShoppingDAO;
import com.shopping.vo.*;

public class ShoppingManager {
	ShoppingDAO dao = new ShoppingDAO();
	// 상품 리스트 가져오기
	public ArrayList<Product> getProductList() {
		return dao.getProductList();
	}
	
	// 상품 주문하기
	public boolean orderProduct(HashMap<Integer, Integer> orderList, String login_id) {
		return dao.insertOrderInfo(orderList, login_id);
	}
	
	// 전체 주문내역 불러오기
	public ArrayList<Order> selectOrderList() {
		return dao.selectOrderList();
	}
	
	// 주문내역 불러오기_아이디
	public ArrayList<Order> selectOrderListById(String user_id) {
		return dao.selectOrderListById(user_id);
	}
	
	// 주문내역 불러오기_주문번호
	public ArrayList<Order> selectOrderListByOrderNo(String order_no) {
		return null;
	}
}
