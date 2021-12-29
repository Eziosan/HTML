package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.*;
import com.mini.vo.*;

public class MusicController {
	
	MusicDAO md = new MusicDAO();
	
		//만약에 hashmap으로 <int, Song>???
		//사용자가 입력한 가수가 포함된 노래 리스트 가져오기
		public ArrayList<Song> searchMusicBySinger(String singer) {
			//가수 가져오기
			ArrayList<Song> songList = md.searchMusicBySinger(singer);
			//사용자 선택
			//해당 곡 가져오기(곡 id로)
			return songList;
		}
		
		//만약에 hashmap으로 <int, Song>???
		//사용자가 입력한 노래가 포함된 노래 리스트 가져오기
		public ArrayList<Song> searchMusicByName(String song) {
		//노래 가져오기
		ArrayList<Song> songList = md.searchMusicByName(song);
		//사용자 선택
		//해당 곡 가져오기(곡 id로)
		return songList;
		}
	
		
}
