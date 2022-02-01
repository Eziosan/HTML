package com.mini.dao;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mini.vo.*;

public class MusicDAO {
	
SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	
	//가수로 노래 찾기
	public ArrayList<Song> selectMusicsBySinger(Singer singer) {
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			
			//노래로 노래 리스트 가져오기
			return mapper.selectMusicsBySinger(singer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	//만약에 hashmap으로 <int, Song>???
	//사용자가 입력한 노래가 포함된 노래 리스트 가져오기
	public ArrayList<Song> searchMusicByName(String song) {
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			
			//노래로 노래 리스트 가져오기
			
			
			return mapper.selectMusicByName(song);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//사용자 선택
		//해당 곡 가져오기(곡 id로)
		return null;
	}
	
	//만약에 hashmap으로 <int, Song>???
	//사용자가 입력한 노래가 포함된 노래 리스트 가져오기
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
	
	//가수 이름으로 가수 리스트 불러오기
	public ArrayList<Singer> getSingersByName(String singer){
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			
			return mapper.getSingersByName(singer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//가수 등록
	public int addSinger(Singer singer) {
		int main_sid = 0;
		
		try (SqlSession session = factory.openSession()) {
			MusicMapper mapper = session.getMapper(MusicMapper.class);
			
			//현재 singer_seq값 가져옴 -> UI에 main_sid값 주기 위함
			main_sid = mapper.getSingerSeq();
			singer.setMain_sid(main_sid);
			
			//가수 등록
			mapper.addSinger(singer);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return main_sid;
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
	
	//현재 로그인한 유저의 전체 리스트 출력
		public ArrayList<PlayList> getUserList(String loginId){
			
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				return mapper.getUserList(loginId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return null;
		}
		
		//유저가 리스트를 선택하면 해당 리스트의 곡 목록 표시
		public ArrayList<PlayList> getUserListSongs(int listId){
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				return mapper.getUserListSongs(listId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		//list_id로 리스트 삭제
		public int  deleteList(int list_id) {
			int result = 0;
			
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				result = mapper.deleteListDetail(list_id);
				result = mapper.deleteList(list_id);
				
				session.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			return result;
		}
		
		public void insertStar(Song song) {
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				mapper.insertStar(song);
				session.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		public void insertComment(SongComment SC) {
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				mapper.insertComment(SC);
				session.commit();
				System.out.println("입력 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<SongComment> selectCommentBySongId(int sid) {
			try (SqlSession session = factory.openSession()) {
				MusicMapper mapper = session.getMapper(MusicMapper.class);
				
				return mapper.selectCommentBySongId(sid);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		

}
