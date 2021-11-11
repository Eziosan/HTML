package com.shopping.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shopping.vo.*;

import java.util.*;

public class ShoppingDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// ��ǰ ����Ʈ ��������
	public ArrayList<Product> getProductList() {
		ArrayList<Product> productList = null;;
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			productList = mapper.getProductList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	// ��ǰ �ֹ����� �Է�
	public boolean insertOrderInfo(HashMap<Integer, Integer> orderList, String login_id) {
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			
			int order_no = mapper.makeOrderNo();
			// �ֹ����� �Է�
			Order orderInfo = new Order();
			orderInfo.setOrder_no(order_no);
			orderInfo.setUser_id(login_id);
			
			mapper.insertOrderInfo(orderInfo);
			
			// �ֹ� ������ �Է�
			Set<Integer> keys = orderList.keySet();
			for (Integer key : keys) {
				Order order_detail = new Order();
				order_detail.setOrder_no(order_no);
				order_detail.setProduct_id(key);
				order_detail.setOrder_cnt(orderList.get(key));
				
				// ��ǰ ����� �ֹ� ������ ������ �ֹ����
				if (mapper.countProductStock(order_detail.getProduct_id()) < order_detail.getOrder_cnt()) {
					return false;
				}
				
				// ��ǰ ��� ����
				mapper.updateProductStock(order_detail);
				mapper.insertOrderDetail(order_detail);
			}
			
			session.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// ��ü �ֹ����� ��������
	public ArrayList<Order> selectOrderList() {
		ArrayList<Order> orderList = null;
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			orderList = mapper.selectOrderList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	// ���̵� �ֹ����� ��������
	public ArrayList<Order> selectOrderListById(String user_id) {
		ArrayList<Order> orderList = null;
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			orderList = mapper.selectOrderListById(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	// �ֹ� ����ϱ�
	public boolean cancel_order(int order_no) {
		boolean result = false;
		ArrayList<Order> orderList = null;
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			
			orderList = mapper.selectOrderListByOrderNo(order_no);
			
			if (orderList != null && orderList.size() > 0) {
				// product ���̺� stock ������Ʈ
				for (Order order : orderList) {
					order.setOrder_cnt(order.getOrder_cnt() * -1);
					mapper.updateProductStock(order);
				}
				
				// order_detail ����
				mapper.delete_order_detail(order_no);
				
				// order_info ����
				mapper.delete_order_info(order_no);
				session.commit();
				result = true;
			} else {
				result = false;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
