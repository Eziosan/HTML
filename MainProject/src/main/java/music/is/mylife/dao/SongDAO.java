package music.is.mylife.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import music.is.mylife.vo.Playlist;
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
	
	
	public ArrayList<Playlist> selectList(String user_id){
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Playlist> playlist = mapper.selectList(user_id);
		
		return playlist;
	}
	
	
	
	
	public void insertList(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int num = mapper.selectListSeq();
		System.out.println("num = "+num);
		
		
		playlist.setPlaylist_id(num);
		
		
		
		mapper.insertList(playlist);
		mapper.insertList_Detail(playlist);
		
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
		
		// 검색 페이지(윤영)
		//곡명으로 검색
		public ArrayList<Song> selectSongsBySongName(String searchText){
			SongMapper mapper = session.getMapper(SongMapper.class);
			ArrayList<Song> searchList1 = mapper.selectSongsBySongName(searchText);
			
			return searchList1;
		}
		//가수명으로 검색
		public ArrayList<Song> selectSongsBySingerName(String searchText){
			SongMapper mapper = session.getMapper(SongMapper.class);
			ArrayList<Song> searchList2 = mapper.selectSongsBySingerName(searchText);
			
			return searchList2;
		}
		
}
