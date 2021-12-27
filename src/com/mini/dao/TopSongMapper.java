package com.mini.dao;

import java.util.ArrayList;

import com.mini.vo.Song;

public interface TopSongMapper {
	/* 탑 10 노래 리스트 불러오기
	 * 
	 *  메소드 이름 : topSong
	 * 
	 * 	파라미터 : 없음
	 * 	리턴타입 : ArrayList<Song>
	*/
	public ArrayList<Song> topSong();
}
