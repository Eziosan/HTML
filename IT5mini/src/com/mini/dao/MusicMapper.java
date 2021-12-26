package com.mini.dao;

import java.util.ArrayList;

import com.mini.vo.Song;

public interface MusicMapper {
	//가사로 노래찾기
	public ArrayList<Song> musicByLyric(String lyrics);
	//찾아온 노래중에 id를 통해서 노래 선택
	public Song showSong(int song_id);
	
	public int enroll(Song song);
}
