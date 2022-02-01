package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.TopSongDAO;
import com.mini.vo.Song;

public class TopSongManager {
	private ArrayList<Song> tlist;
	private TopSongDAO dao = new TopSongDAO();
	
	/* 탑 10 노래 리스트 불러오기
	 * 
	 *  메소드 이름 :  topSong
	 *  
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Song>
	*/
	public ArrayList<Song> topSong() {
		tlist = dao.topSong();
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
		// 변수 s에  topSongDetail 정보 담음
		Song s = dao.topSongDetail(song);
		return s;
	}
	
}
