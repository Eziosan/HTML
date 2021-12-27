package com.mini.dao;

import java.util.ArrayList;

import com.mini.vo.Concert;

public interface ConcertMapper {
	/* 콘서트 리스트 전체 출력
	 * 
	 *  메소드 이름 : concertList
	 * 
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Concert>
	*/
	public ArrayList<Concert> concertList();
}
