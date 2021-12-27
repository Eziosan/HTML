package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.TopSongDAO;
import com.mini.vo.Song;

public class TopSongManager {
	private ArrayList<Song> tlist;
	private TopSongDAO dao = new TopSongDAO();
	
	/* 노래 탑 10 곡 전체 출력
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
	
}
