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
	
	//곡 아이디로 곡 정보 가져오기
	public Song selectSongsById(int song_id){
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		return mapper.selectSongsById(song_id);
		
	}

	
	
	public String selectAlbumImg(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		String aimg = mapper.selectAlbumImg(song_id);
		
		return aimg;
	}
	
	
	public Song selectSongOne(int song_id) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		Song song = mapper.selectSongOne(song_id);
		
		return song;
	}
	
	//유저와 리스트이름이 중복되는 리스트가 있는지 확인
	public int listDupleCheck(Playlist pl) {
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		return mapper.listDupleCheck(pl);
	}
	
	public ArrayList<Playlist> selectList(String user_id){
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Playlist> playlist = mapper.selectList(user_id);
		
		return playlist;
	}
	
	
	
	
	public int insertList(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int num = mapper.selectListSeq();
		System.out.println("num = "+num);
		
		
		playlist.setPlaylist_id(num);
		
		
		
		return mapper.insertList(playlist);
		//mapper.insertList_Detail(playlist);
		
	}
	
	
	
	public void insertSong(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int playlist_id = playlist.getPlaylist_id();
		
		// 플레이리스트 디테일에 곡 넣기
		mapper.insertList_Detail(playlist);  
		// 플레이리스트에 날짜 업데이트
		mapper.updateList_Date(playlist_id);
		
		
		
	
	}
	
	public int selectSongCount(Playlist playlist) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		
		
		int count = mapper.selectSongCount(playlist);
		
		return count;
	}
	
	
	
	public int selectPlayListId(String list_name) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		int playlist_id = mapper.selectPlayListId(list_name);
		
		return playlist_id;
	}
	
	// 특정 곡의 별점을 가져오는 sql문
	public double selectStars(int song_id) {
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		double avg = 0.0;
		int count = mapper.selectIsStars(song_id);
		
		if(count > 0 ) {
			
			avg = mapper.selectStars(song_id);
			
			
		}
		
			return avg;
		
	}
	
	
	public ArrayList<Playlist> selectTop4ListBySongId(int song_id){
		
		SongMapper mapper = session.getMapper(SongMapper.class);
		
		ArrayList<Playlist> list = mapper.selectTop4ListBySongId(song_id);
		
		
		return list;
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
		public ArrayList<Song> selectSongByGenre(String genre){
			SongMapper mapper = session.getMapper(SongMapper.class);
			
			ArrayList<Song> likeSong = mapper.selectSongByGenre(genre);
			
			return likeSong;
		}
		
		/**
		 * 전체 곡 검색
		 * @param song
		 * @return song
		 */
		public Song selectAllSong(Song song) {
			SongMapper mapper = session.getMapper(SongMapper.class);
			
			Song selectSong = mapper.selectAllSong(song);
			
			
			return selectSong;
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
