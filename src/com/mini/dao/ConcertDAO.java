package com.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.Concert;

public class ConcertDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/* 콘서트 리스트 전체 출력
	 * 
	 *  메소드 이름 : concertList
	 * 
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Concert>
	*/
	public ArrayList<Concert> concertList(){
		//ArrayList<Concert> 객체
		ArrayList<Concert> clist = new ArrayList<Concert>();
		
		try(SqlSession session = factory.openSession()) {
			ConcertMapper mapper = session.getMapper(ConcertMapper.class);
			
			//list에 콘서트 리스트 데이터 담기
			clist = mapper.concertList();
			
			return clist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
