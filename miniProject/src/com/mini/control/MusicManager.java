package com.mini.control;

import java.util.ArrayList;

import com.mini.dao.*;
import com.mini.vo.*;

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
	
	//가수 이름으로 가수 리스트 불러오기
	public ArrayList<Singer> getSingersByName(String singer){
			
		return md.getSingersByName(singer);
	}
	
	//가수 등록
	public int addSinger(Singer singer) {
		
		return md.addSinger(singer);
	}
	
	// 곡 등록
	public boolean enroll(Song song) {
		
		return md.enroll(song);
	}
	
	//현재 로그인한 유저의 전체 리스트 출력
	public ArrayList<PlayList> getUserList(String loginId){
		
		return md.getUserList(loginId);
	}
	
	//유저가 리스트를 선택하면 해당 리스트의 곡 목록 표시
	public ArrayList<PlayList> getUserListSongs(int listId){
		
		return md.getUserListSongs(listId);
	}
	
	//list_id로 리스트 삭제
	public boolean deleteList(int list_id) {
		if(md.deleteList(list_id) > 0) {
			return true;
			
		}else { return false;}
			
	}
}
