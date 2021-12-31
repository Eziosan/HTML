package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.ConcertDAO;
import com.mini.vo.Concert;

public class ConcertManager {
	private ArrayList<Concert> clist;
	private ConcertDAO dao = new ConcertDAO();
	
	
	public ArrayList<Concert> concertSinger(String singer_name) {
		ArrayList<Concert> slist = dao.concertSinger(singer_name);
		
		return slist; 
	}
	
	public Concert concertOne(int concert_id) {
		Concert c = dao.concertOne(concert_id);
		
		return c;
	}
	
	/* 콘서트 리트스 출력(콘서트 이름, 가수)
	 * 
	 *  메소드 이름 : concertList
	 * 
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Concert>
	*/
	public ArrayList<Concert> concertList(){
		clist = dao.concertList();
		return clist;
	}
	
	/* 콘서트 상세정보 출력
	 * 
	 *  메소드 이름 : concertDetail
	 *  
	 *  파라미터 타입 : Concert
	 *     변수이름 : concert
	 *  리턴타입 : Concert
	 * 
	*/
	public Concert concertDetail(int concert_id) {
		Concert c = dao.concertDetail(concert_id);
		return c;
	}
}
