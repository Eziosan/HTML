package music.is.mylife.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.Song;

@Repository
public class SongDAO {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	SqlSession sqlSession;
	
	// 가장 추천수가 높은 배너를 가져오는 메소드
	public String selectBanner(int song_id){
		SongMapper mapper = sqlSession.getMapper(SongMapper.class);
		
		
		String banner = mapper.selectBanner(song_id);
		
		return banner;
	}
	
	// 메인 페이지(화원)
	
	/**
	 * 조회수가 높은 순으로 상위 5개의 곡 출력
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectTopSong(Song song){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Song> songList = mapper.selectTopSong(song);
		
		return songList;
	}
	
	/**
	 * 좋아요가 높은 순으로 상위 5개 곡 출력
	 * @param song
	 * @return ArrayList<Song>
	 */
	public ArrayList<Song> selectLikeSong(Song song){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Song> likeSong = mapper.selectLikeSong(song);
		
		return likeSong;
	}
}
