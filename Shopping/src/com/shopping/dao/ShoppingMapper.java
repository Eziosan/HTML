package com.shopping.dao;

import com.shopping.vo.*;
import java.util.*;

public interface ShoppingMapper {
	// ��ǰ����Ʈ �ҷ�����
	public ArrayList<Product> getProductList();
	// �ֹ���ȣ ����
	public int makeOrderNo();
	// ��ǰ �ֹ����� �Է�
	public int insertOrderInfo(Order order);
	// ��ǰ ��� ���� ��ȸ
	public int countProductStock(int product_id);
	// ��ǰ ��� ����
	public int updateProductStock(Order order);
	// �ֹ����� �� �Է�
	public int insertOrderDetail(Order order);
	// ��ü �ֹ����� �ҷ�����
	public ArrayList<Order> selectOrderList();
	// �ֹ����� �ҷ�����_���̵�
	public ArrayList<Order> selectOrderListById(String user_id);
	// �ֹ����� �ҷ�����_�ֹ���ȣ
	public ArrayList<Order> selectOrderListByOrderNo(int order_no);
	// �ֹ� �󼼳��� ����
	public int delete_order_detail(int order_no);
	// �ֹ� ���� ����
	public int delete_order_info(int order_no);
}
