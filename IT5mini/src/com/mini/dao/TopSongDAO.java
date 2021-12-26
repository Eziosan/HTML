package com.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.Song;

public class TopSongDAO {
	SqlSessionFactory factroy = MybatisConfig.getSqlSessionFactory();
	
		/* 탑 10 노래 리스트 불러오기
		 * 
		 *  메소드 이름 : topSong
		 * 
		 * 	파라미터 : 없음
		 * 	리턴타입 : ArrayList<Song>
		*/
	public ArrayList<Song> topSong(){
		//ArrayList<Song> 객체
		ArrayList<Song> tlist = new ArrayList<Song>();
		
		try(SqlSession session = factroy.openSession()) {
			TopSongMapper mapper = session.getMapper(TopSongMapper.class);
			
			//list에 탑 10 노래 리스트 데이터 담기
			tlist.addAll(mapper.topSong());
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tlist;
	}
}
