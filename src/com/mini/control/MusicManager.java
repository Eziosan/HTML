package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.MusicDAO;
import com.mini.vo.Song;

public class MusicManager {
	
	MusicDAO md = new MusicDAO();
	
	//만약에 hashmap으로 <int, Song>???
	//사용자가 입력한 가사가 포함된 노래 리스트 가져오기
	public ArrayList<Song> musicByLyric(String lyrics) {
		//가사 가져오기
		ArrayList<Song> songList = md.musicByLyric(lyrics);
		//사용자 선택
		//해당 곡 가져오기(곡 id로)
		return songList;
	}

	//곡 id로 해당 곡 정보 표시
	public Song showSong(int song_id) {
		
		Song song = md.showSong(song_id);
		
		return song;
	}
	
	public boolean enroll(Song song) {
		
		return md.enroll(song);
	}
}
