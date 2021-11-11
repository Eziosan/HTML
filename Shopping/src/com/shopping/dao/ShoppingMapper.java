package com.shopping.dao;

import com.shopping.vo.*;
import java.util.*;

public interface ShoppingMapper {
	// 상품리스트 불러오기
	public ArrayList<Product> getProductList();
	// 주문번호 생성
	public int makeOrderNo();
	// 상품 주문정보 입력
	public int insertOrderInfo(Order order);
	// 상품 재고 수량 조회
	public int countProductStock(int product_id);
	// 상품 재고 수정
	public int updateProductStock(Order order);
	// 주문정보 상세 입력
	public int insertOrderDetail(Order order);
	// 전체 주문내역 불러오기
	public ArrayList<Order> selectOrderList();
	// 주문내역 불러오기_아이디
	public ArrayList<Order> selectOrderListById(String user_id);
	// 주문내역 불러오기_주문번호
	public ArrayList<Order> selectOrderListByOrderNo(int order_no);
	// 주문 상세내역 삭제
	public int delete_order_detail(int order_no);
	// 주문 내역 삭제
	public int delete_order_info(int order_no);
}
