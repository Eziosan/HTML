package com.shopping.control;

import java.util.*;

import com.shopping.dao.ShoppingDAO;
import com.shopping.vo.*;

public class ShoppingManager {
	ShoppingDAO dao = new ShoppingDAO();
	// ��ǰ ����Ʈ ��������
	public ArrayList<Product> getProductList() {
		return dao.getProductList();
	}
	
	// ��ǰ �ֹ��ϱ�
	public boolean orderProduct(HashMap<Integer, Integer> orderList, String login_id) {
		return dao.insertOrderInfo(orderList, login_id);
	}
	
	// ��ü �ֹ����� �ҷ�����
	public ArrayList<Order> selectOrderList() {
		return dao.selectOrderList();
	}
	
	// �ֹ����� �ҷ�����_���̵�
	public ArrayList<Order> selectOrderListById(String user_id) {
		return dao.selectOrderListById(user_id);
	}
	
	// �ֹ����� �ҷ�����_�ֹ���ȣ
	public ArrayList<Order> selectOrderListByOrderNo(String order_no) {
		return null;
	}
}
