package com.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.Song;

public class TopSongDAO {
	SqlSessionFactory factroy = MybatisConfig.getSqlSessionFactory();

	/*
	 * 탑 10 노래 리스트 불러오기
	 * 
	 * 메소드 이름 : topSong
	 * 
	 * 	파라미터 : 없음 
	 * 	리턴타입 : ArrayList<Song>
	 */
	public ArrayList<Song> topSong() {
		// ArrayList<Song> 객체
		ArrayList<Song> tlist = new ArrayList<Song>();

		try (SqlSession session = factroy.openSession()) {
			TopSongMapper mapper = session.getMapper(TopSongMapper.class);

			// list에 탑 10 노래 리스트 데이터 담기
			tlist.addAll(mapper.topSong());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tlist;
	}

	/*
	 * 탑 10 곡 상세 정보 출력
	 * 
	 * 메소드 이름 : topSongDetail
	 * 	
	 * 	파라미터 타입 : Song 
	 * 	       변수이름 : song
	 * 	리턴타입 : Song
	 * 
	 */
	public Song topSongDetail(Song song) {
		try (SqlSession session = factroy.openSession()) {
			TopSongMapper mapper = session.getMapper(TopSongMapper.class);

			Song topsong = mapper.topSongDetail(song);

			return topsong;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
