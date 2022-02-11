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
	
	
	
	// 가장 추천수가 높은 배너를 가져오는 메소드
	public String selectBanner(int song_id){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		
		String banner = mapper.selectBanner(song_id);
		
		return banner;
	}
	
	public String selectAlbumImg(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		String aimg = mapper.selectAlbumImg(song_id);
		
		return aimg;
	}
	
	public Integer selectSongLike(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		Integer slike = mapper.selectSongLike(song_id);
		
		return slike;
	}
	
	public int plusSongLike(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int psl = mapper.plusSongLike(song_id);
		
		return psl;
	}
	
	public int minusSongLike(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int msl = mapper.minusSongLike(song_id);
		
		return msl;
	}
	
	public Song selectSongOne(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		Song song = mapper.selectSongOne(song_id);
		
		return song;
	}
}
