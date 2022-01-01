package com.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.Concert;

public class ConcertDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	
	public ArrayList<Concert> concertSinger(String singer_name) {
		try(SqlSession session = factory.openSession()) {
			ConcertMapper mapper = session.getMapper(ConcertMapper.class);
			
			ArrayList<Concert> slist = mapper.concertSinger(singer_name);
			
			return slist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Concert concertOne(int concert_id) {
		try(SqlSession session = factory.openSession()) {
			ConcertMapper mapper = session.getMapper(ConcertMapper.class);
			
			Concert c = mapper.concertOne(concert_id);
			
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/* 콘서트 리트스 출력(콘서트 이름, 가수)
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
		try(SqlSession session = factory.openSession()) {
			ConcertMapper mapper = session.getMapper(ConcertMapper.class);
			//c 객체에 콘서트 디테일 데이터 담기
			Concert c = mapper.concertDetail(concert_id);
			
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
