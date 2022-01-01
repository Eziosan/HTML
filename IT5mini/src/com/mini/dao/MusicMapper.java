package com.mini.dao;

import java.util.ArrayList;

import com.mini.vo.*;

public interface MusicMapper {
	
		
	//1. 노래로 노래 찾기
	public ArrayList<Song> selectMusicByName(String song);	
	
	//가사로 노래 찾기
	public ArrayList<Song> musicByLyric(String lyrics);
	
	//노래 id로 노래 가져찾기
	public Song showSong(int song_id);
	
	//별점 입력
	public void insertStar(Song song);
	
	//코멘트 입력
	public void insertComment(SongComment SC);
	
	//코멘트 출력
	public ArrayList<SongComment> selectCommentBySongId(int sid);
	
	//조회수 증가
	public int addHits(Song song);

	//가수 이름으로 가수 리스트 불러오기
	public ArrayList<Singer> getSingersByName(String singer);
	
	//가수로 노래 찾기
	public ArrayList<Song> selectMusicsBySinger(Singer singer);
	
	//가수id로 가수 찾기
	public Singer selectSingerBySid(int sid);
	
	//singer테이블에서 현재 시퀀스 값 가져오기
	public int getSingerSeq();

	//가수 등록
	public int addSinger(Singer singer);
	
	//곡 등록 
	public int enroll(Song song);
	
	//현재 로그인한 유저의 전체 리스트 출력
	public ArrayList<PlayList> getUserList(String loginId);
	
	//리스트id로 플레이 리스트 리스트 불러오기
	public ArrayList<PlayList> getUserListSongs(int listId);
	
	// 다음 list 시퀀스 값을 가져옴
	public int getListSeq();
	
	//playlist 에 곡 등록
	public int addList(PlayList pList);
	
	//playlist_detail 에 곡 등록
	public int addListDetail(PlayList pList);
	
	// 한 유저는 같은 이름의 리스트를 만들 수 없음
	public int listNameDupleCheck(PlayList pList);
	// 한 리스트 안에선 곡 중복 안됨. 중복체크
	public int listSongDupleCheck(PlayList pList);
	
	//list_id로 리스트 삭제
	public int deleteList(int list_id);
	
	//list_id로 리스트 삭제
	public int deleteListDetail(int list_id);
	
}
