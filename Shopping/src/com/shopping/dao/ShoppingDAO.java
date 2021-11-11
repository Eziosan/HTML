package com.shopping.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shopping.vo.*;

import java.util.*;

public class ShoppingDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	// 상품 리스트 가져오기
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
	
	// 상품 주문정보 입력
	public boolean insertOrderInfo(HashMap<Integer, Integer> orderList, String login_id) {
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			
			int order_no = mapper.makeOrderNo();
			// 주문정보 입력
			Order orderInfo = new Order();
			orderInfo.setOrder_no(order_no);
			orderInfo.setUser_id(login_id);
			
			mapper.insertOrderInfo(orderInfo);
			
			// 주문 상세정보 입력
			Set<Integer> keys = orderList.keySet();
			for (Integer key : keys) {
				Order order_detail = new Order();
				order_detail.setOrder_no(order_no);
				order_detail.setProduct_id(key);
				order_detail.setOrder_cnt(orderList.get(key));
				
				// 상품 재고보다 주문 수량이 많으면 주문취소
				if (mapper.countProductStock(order_detail.getProduct_id()) < order_detail.getOrder_cnt()) {
					return false;
				}
				
				// 상품 재고 수정
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
	
	// 전체 주문내역 가져오기
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
	
	// 아이디별 주문내역 가져오기
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
	
	// 주문 취소하기
	public boolean cancel_order(int order_no) {
		boolean result = false;
		ArrayList<Order> orderList = null;
		try (SqlSession session = factory.openSession()) {
			ShoppingMapper mapper = session.getMapper(ShoppingMapper.class);
			
			orderList = mapper.selectOrderListByOrderNo(order_no);
			
			if (orderList != null && orderList.size() > 0) {
				// product 테이블 stock 업데이트
				for (Order order : orderList) {
					order.setOrder_cnt(order.getOrder_cnt() * -1);
					mapper.updateProductStock(order);
				}
				
				// order_detail 삭제
				mapper.delete_order_detail(order_no);
				
				// order_info 삭제
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
