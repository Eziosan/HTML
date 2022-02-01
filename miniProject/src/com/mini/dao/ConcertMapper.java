package com.mini.dao;

import java.util.ArrayList;


import com.mini.vo.Concert;

public interface ConcertMapper {
	
	/* 가수이름으로 콘서트 검색, 출력
	 * 
	 * */
	public ArrayList<Concert> concertSinger(String singer_name);
	
	/* 콘서트 객체 1개 들고오기
	 * 
	 * */
	public Concert concertOne(int concert_id);
	
	/* 콘서트 리트스 출력(콘서트 이름, 가수)
	 * 
	 *  메소드 이름 : concertList
	 * 
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Concert>
	*/
	public ArrayList<Concert> concertList();
	
	/* 콘서트 상세정보 출력
	 * 
	 *  메소드 이름 : concertDetail
	 *  
	 *  파라미터 타입 : Concert
	 *     변수이름 : concert
	 *  리턴타입 : Concert
	 * 
	*/
	public Concert concertDetail(int concert_id);
}
