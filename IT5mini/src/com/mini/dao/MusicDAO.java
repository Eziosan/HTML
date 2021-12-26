package com.mini.dao;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.Song;

public class MusicDAO {
	
SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//만약에 hashmap으로 <int, Song>???
	//사용자가 입력한 가사가 포함된 노래 리스트 가져오기
	public ArrayList<Song> musicByLyric(String lyrics) {
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			
			//가사로 노래 리스트 가져오기
			ArrayList<Song> songList = mapper.musicByLyric(lyrics);
			
			return songList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//사용자 선택
		//해당 곡 가져오기(곡 id로)
		return null;
	}
	
	//song_id로 노래검색
	public Song showSong(int song_id) {
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			Song song = mapper.showSong(song_id);
			
			return song;	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}
	
	// 곡 등록
	public boolean enroll(Song song) {
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			int result = mapper.enroll(song);
			
			if(result > 0) {
				session.commit();
				
				return true;	
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
